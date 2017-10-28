package _05SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double consumptionPerKM;
    private int distanceTravelled = 0;

    public Car(String model, double fuelAmount, double consumptionPerKM) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.consumptionPerKM = consumptionPerKM;
    }

    public void drive(int distance) {
        if ((this.consumptionPerKM * distance) <= this.fuelAmount) {
            this.fuelAmount -= this.consumptionPerKM * distance;
            this.distanceTravelled += distance;
        } else {
            throw new IllegalStateException("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTravelled);
    }
}
