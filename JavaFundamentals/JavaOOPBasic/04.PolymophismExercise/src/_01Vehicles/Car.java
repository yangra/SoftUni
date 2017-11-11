package _01Vehicles;

public class Car extends Vehicle {

    public Car(double tank, double consumption) {
        super(tank, consumption);
    }

    @Override
    public double getConsumption() {
        return super.getConsumption() + Constants.CAR_AIR_CONDITION_CONSUMPTION;
    }


    void drive(double kilometers) {
        if (super.getTank() / this.getConsumption() < kilometers) {
            throw new IllegalArgumentException("Car needs refueling");
        }
        super.setTank(super.getTank() - (kilometers * this.getConsumption()));
    }

    void refuel(double fuel) {
        super.setTank(super.getTank() + fuel);
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
