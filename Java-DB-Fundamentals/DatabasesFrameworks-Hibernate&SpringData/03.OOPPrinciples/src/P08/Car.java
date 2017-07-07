package P08;


import java.text.DecimalFormat;

public class Car extends VehicleImpl {

     Car(Double quantity, Double consumption) {
        super(quantity, consumption + 0.9);
    }

}
