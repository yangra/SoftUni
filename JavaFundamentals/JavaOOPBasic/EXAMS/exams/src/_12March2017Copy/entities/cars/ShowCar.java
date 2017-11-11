package _12March2017Copy.entities.cars;

import _12March2017Copy.entities.cars.Car;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.setStars(0);
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        super.tune(tuneIndex, tuneAddOn);
        this.stars += tuneIndex;
    }

    private void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%d *", this.stars);
    }
}
