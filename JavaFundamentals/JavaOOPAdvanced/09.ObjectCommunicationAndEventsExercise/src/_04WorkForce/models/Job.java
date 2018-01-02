package _04WorkForce.models;

import _04WorkForce.interfaces.Employee;
import _04WorkForce.interfaces.ObservableAction;
import _04WorkForce.interfaces.Observer;

public class Job implements ObservableAction {
    private String name;
    private int workHoursRequired;
    private Employee employee;
    private Observer observer;

    public Job(String name, int workHoursRequired, Employee employee) {
        this.name = name;
        this.workHoursRequired = workHoursRequired;
        this.employee = employee;
        this.observer = ObserverImpl.instance();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWorkHoursRequired() {
        return this.workHoursRequired;
    }

    @Override
    public void update() {
        this.workHoursRequired -= this.employee.getWorkHoursPerWeek();
        if (this.workHoursRequired <= 0) {
            this.observer.notifyObserver(this);
        }
    }
}
