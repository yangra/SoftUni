package _02VehiclesExtension;

public class Bus extends Vehicle {


    protected Bus(double tank, double consumption, double tankCapacity) {
        super(tank, consumption, tankCapacity);
    }

    @Override
    protected void setConsumption(double consumption) {
        super.setConsumption(consumption + Constants.BUS_AIR_CONDITION_CONSUMPTION);
    }


    void turnOffConditioner() {
        setConsumption(super.getConsumption() - Constants.BUS_AIR_CONDITION_CONSUMPTION);
    }

    void turnOnConditioner() {
        setConsumption(super.getConsumption() + Constants.BUS_AIR_CONDITION_CONSUMPTION);
    }

    @Override
    void turnOffConditioner(Visitor visitor) {
        visitor.turnOffConditioner(this);
    }

    @Override
    void turnOnConditioner(Visitor visitor) {
        visitor.turnOnConditioner(this);
    }

}
