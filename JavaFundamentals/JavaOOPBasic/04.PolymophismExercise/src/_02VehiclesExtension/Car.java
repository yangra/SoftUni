package _02VehiclesExtension;

public class Car extends Vehicle {


    public Car(double tank, double consumption, double tankCapacity) {
        super(tank, consumption, tankCapacity);
        this.setConsumption(consumption);
    }

    @Override
    public void setConsumption(double consumption) {
        super.setConsumption(consumption + Constants.CAR_AIR_CONDITION_CONSUMPTION);
    }

    @Override
    void turnOffConditioner(Visitor visitor) {
    }

    @Override
    void turnOnConditioner(Visitor visitor) {

    }


}
