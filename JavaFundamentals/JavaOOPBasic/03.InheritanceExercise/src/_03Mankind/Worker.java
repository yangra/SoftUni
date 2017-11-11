package _03Mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double getSalaryPerHour() {
        return this.weekSalary / workHoursPerDay / 7;
    }

    @Override
    void setLastName(String lastName) {
        if (lastName.length() < 4) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Week Salary: ").append(String.format("%.2f", this.weekSalary))
                .append(System.lineSeparator());
        sb.append("Hours per day: ").append(String.format("%.2f", this.workHoursPerDay))
                .append(System.lineSeparator());
        sb.append("Salary per hour: ").append(String.format("%.2f", this.getSalaryPerHour()))
                .append(System.lineSeparator());
        return sb.toString();
    }
}


