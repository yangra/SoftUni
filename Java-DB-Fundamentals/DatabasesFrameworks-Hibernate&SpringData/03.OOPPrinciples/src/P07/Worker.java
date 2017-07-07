package P07;


public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    double getWeekSalary() {
        return weekSalary;
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary > 10) {
            this.weekSalary = weekSalary;
        } else {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
    }

    double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay <= 12 && workHoursPerDay >= 1) {
            this.workHoursPerDay = workHoursPerDay;
        }else {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
    }

    @Override
    public void setLastName(String lastName) {
        if (lastName.length() > 3) {
            super.setLastName(lastName);
        } else {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
    }

    @Override
    public String toString() {
        return String.format("First Name: %s\n" +
                        "Last Name: %s\n" +
                        "Week Salary: %.2f\n" +
                        "Hours per day: %.2f\n" +
                        "Salary per hour: %.2f\n",
                this.getFirstName(),
                this.getLastName(),
                this.getWeekSalary(),
                this.getWorkHoursPerDay(),
                this.getWeekSalary()/(this.getWorkHoursPerDay()*7));
    }
}
