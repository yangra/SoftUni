package _12March2017.entities.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        modifyStats();
        this.addOns = new ArrayList<>();
    }

    private void modifyStats() {
        super.setHorsepower(this.getHorsepower() + this.getHorsepower() / 2);
        super.setSuspension(this.getSuspension() - this.getSuspension() / 4);
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
