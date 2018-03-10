package enterprise;

import java.util.*;


public class Enterprise implements IEnterprise {

    private Map<UUID, Employee> employees;
    private Map<Position, List<Employee>> byPosition;
    private Map<String, List<Employee>> byName;

    public Enterprise() {
        this.employees = new LinkedHashMap<>();
        this.byPosition = new HashMap<>();
        this.byName = new HashMap<>();
    }

    @Override
    public void add(Employee employee) {
        if (this.employees.containsKey(employee.getId())) {
            return;
        }

        if (!this.byPosition.containsKey(employee.getPosition())) {
            this.byPosition.put(employee.getPosition(), new ArrayList<>());
        }
        this.byPosition.get(employee.getPosition()).add(employee);
        if (!this.byName.containsKey(employee.getFirstName() + employee.getLastName())) {
            this.byName.put(employee.getFirstName() + employee.getLastName(), new ArrayList<>());
        }
        this.byName.get(employee.getFirstName() + employee.getLastName()).add(employee);
        this.employees.put(employee.getId(), employee);
    }

    @Override
    public boolean contains(UUID id) {
        return this.employees.containsKey(id);
    }

    @Override
    public boolean contains(Employee employee) {
        return this.employees.containsKey(employee.getId());
    }

    @Override
    public boolean change(UUID id, Employee employee) {
        if (!this.employees.containsKey(id)) {
            return false;
        }

        Employee original = this.employees.get(id);
        original.setSalary(employee.getSalary());
        original.setFirstName(employee.getFirstName());
        original.setLastName(employee.getLastName());
        original.setSalary(employee.getSalary());
        original.setHireDate(employee.getHireDate());
        original.setPosition(employee.getPosition());
        return true;
    }

    @Override
    public boolean fire(UUID id) {
        if (!this.employees.containsKey(id)) {
            return false;
        }
        this.employees.remove(id);
        return true;
    }

    @Override
    public boolean raiseSalary(int months, int percent) {
        boolean found = false;
        Calendar calendar = Calendar.getInstance();
        for (Employee employee : this.employees.values()) {
            calendar.setTime(employee.getHireDate());
            calendar.add(Calendar.MONTH, months);
            if (calendar.getTime().compareTo(new Date()) < 0) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * percent / 100);
                found = true;
            }
        }
        return found;
    }

    @Override
    public int getCount() {
        return this.employees.size();
    }

    @Override
    public Employee getByUUID(UUID id) {
        if (!this.employees.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        return this.employees.get(id);
    }

    @Override
    public Position positionByUUID(UUID id) {
        if (!this.employees.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        return this.employees.get(id).getPosition();
    }

    @Override
    public Iterable<Employee> getByPosition(Position position) {
        if (!byPosition.containsKey(position)) {
            throw new IllegalArgumentException();
        }
        return this.byPosition.get(position);
    }

    @Override
    public Iterable<Employee> getBySalary(double minSalary) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees.values()) {
            if (employee.getSalary() >= minSalary) {
                result.add(employee);
            }
        }

        if (result.size() <= 0) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    @Override
    public Iterable<Employee> getBySalaryAndPosition(double salary, Position position) {
        if (!this.byPosition.containsKey(position)) {
            throw new IllegalArgumentException();
        }

        List<Employee> employeesByPosition = this.byPosition.get(position);
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeesByPosition) {
            if (employee.getSalary() == salary) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public Iterable<Employee> searchBySalary(double minSalary, double maxSalary) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : this.employees.values()) {
            if (employee.getSalary() >= minSalary && employee.getSalary() <= maxSalary) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public Iterable<Employee> searchByPosition(Iterable<Position> positions) {
        List<Employee> result = new ArrayList<>();
        for (Position position : positions) {
            if (this.byPosition.get(position) != null) {
                result.addAll(this.byPosition.get(position));
            }
        }
        return result;
    }

    @Override
    public Iterable<Employee> allWithPositionAndMinSalary(Position position, double minSalary) {
        if (!this.byPosition.containsKey(position)) {
            return new ArrayList<>();
        }
        List<Employee> employeesWithPosition = this.byPosition.get(position);
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeesWithPosition) {
            if (employee.getSalary() >= minSalary) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public Iterable<Employee> searchByFirstName(String firstName) {
        List<Employee> result = new ArrayList<>();
        for (String s : this.byName.keySet()) {
            if (s.startsWith(firstName)) {
                result.addAll(this.byName.get(s));
            }
        }
        return result;
    }

    @Override
    public Iterable<Employee> searchByNameAndPosition(String firstName, String lastName, Position position) {
        if (!this.byName.containsKey(firstName + lastName)) {
            return new ArrayList<>();
        }
        List<Employee> employees = this.byName.get(firstName + lastName);
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getPosition().equals(position)) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public Iterator<Employee> iterator() {
        return this.employees.values().iterator();
    }
}
