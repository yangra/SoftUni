package _01Vehicles;

abstract class Vehicle {
    private double tank;
    private double consumption;

    protected Vehicle(double tank, double consumption) {
        this.tank = tank;
        this.consumption = consumption;
    }

    public double getTank() {
        return this.tank;
    }

    protected void setTank(double tank) {
        this.tank = tank;
    }

    public double getConsumption() {
        return this.consumption;
    }

    protected abstract void drive(Visitor visitor, double kilometers);
    protected abstract void refuel( Visitor visitor, double fuel);

}
