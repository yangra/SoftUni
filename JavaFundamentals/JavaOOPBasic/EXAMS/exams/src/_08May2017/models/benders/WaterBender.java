package _08May2017.models.benders;

public class WaterBender extends Bender {
    private double waterClarity;
    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    @Override
    public double getTotalPower() {
        return this.getPower()*this.waterClarity;
    }

    @Override
    public String toString() {
        return String.format("###Water Bender: %s, Power: %d, Water Clarity: %.2f",
                this.getName(), this.getPower(), this.waterClarity);
    }


}
