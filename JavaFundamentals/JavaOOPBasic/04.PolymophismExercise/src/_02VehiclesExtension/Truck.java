package _02VehiclesExtension;

public class Truck extends Vehicle {


    protected Truck(double tank, double consumption, double tankCapacity) {
        super(tank, consumption, tankCapacity);
        this.setConsumption(consumption);
    }

    @Override
    public void setConsumption(double consumption) {
        super.setConsumption(consumption + Constants.TRUCK_AIR_CONDITION_CONSUMPTION);
    }

    @Override
    void refuel(double fuel) {
        super.refuel(fuel * Constants.TRUCK_REFUEL_PERCENTAGE);
    }

    @Override
    void turnOffConditioner(Visitor visitor) {
    }

    @Override
    void turnOnConditioner(Visitor visitor) {
    }

}
