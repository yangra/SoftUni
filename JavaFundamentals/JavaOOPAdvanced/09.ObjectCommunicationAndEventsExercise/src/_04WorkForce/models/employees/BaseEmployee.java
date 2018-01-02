package _04WorkForce.models.employees;

import _04WorkForce.interfaces.Employee;

public abstract class BaseEmployee implements Employee {
    private String name;
    private int workHoursPerWeek;

    protected BaseEmployee(String name, int workHoursPerWeek) {
        this.name = name;
        this.workHoursPerWeek = workHoursPerWeek;
    }

    @Override
    public int getWorkHoursPerWeek() {
        return this.workHoursPerWeek;
    }
}
