package _01Vehicles;

public class Truck extends Vehicle {

    public Truck(double tank, double consumption) {
        super(tank, consumption);
    }

    @Override
    public double getConsumption() {
        return super.getConsumption() + Constants.TRUCK_AIR_CONDITION_CONSUMPTION;
    }

    void drive(double kilometers) {
        if (super.getTank() / this.getConsumption() < kilometers) {
            throw new IllegalArgumentException("Truck needs refueling");
        }
        super.setTank(super.getTank() - (kilometers * this.getConsumption()));
    }


    void refuel(double fuel) {
        super.setTank(super.getTank() + fuel * Constants.TRUCK_REFUEL_PERCENTAGE);
    }

    @Override
    protected void drive(Visitor visitor, double kilometers) {
        visitor.drive(this, kilometers);
    }

    @Override
    protected void refuel(Visitor visitor, double fuel) {
        visitor.refuel(this, fuel);
    }
}
