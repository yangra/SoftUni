package P08;


import java.text.DecimalFormat;

public class Truck extends VehicleImpl {

    Truck(Double quantity, Double consumption) {
        super(quantity, consumption + 1.6);
    }

    @Override
    public void refuel(Double litres) {
        super.refuel(litres * 0.95);
    }


}
