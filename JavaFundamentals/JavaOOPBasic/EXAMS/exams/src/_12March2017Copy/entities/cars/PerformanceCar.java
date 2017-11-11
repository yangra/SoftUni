package _12March2017Copy.entities.cars;

import _12March2017Copy.entities.cars.Car;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    protected void setHorsepower(int horsepower) {
        super.setHorsepower(horsepower + horsepower / 2);
    }

    @Override
    protected void setSuspension(int suspension) {
        super.setSuspension(suspension - suspension / 4);
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        super.tune(tuneIndex, tuneAddOn);
        this.addOns.add(tuneAddOn);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Add-ons: %s",
                this.addOns.size() > 0 ? this.addOns.toString().replaceAll("[\\[\\]]", "") : "None");
    }
}
