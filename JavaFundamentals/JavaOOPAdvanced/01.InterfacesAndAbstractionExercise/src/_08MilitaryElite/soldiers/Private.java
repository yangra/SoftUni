package _08MilitaryElite.soldiers;

import _08MilitaryElite.interfaces.IPrivate;

public class Private extends Soldier implements IPrivate {
    private double salary;

    public Private(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Salary: %.2f", this.salary);
    }
}
