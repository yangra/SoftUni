package Kermen.models.items;

public class Device {
    private double electricityCost;

    public Device(double electricityCost) {
        this.electricityCost = electricityCost;
    }

    public double getElectricityCost() {
        return this.electricityCost;
    }
}
