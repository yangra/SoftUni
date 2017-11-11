package _08May2017.models.benders;

public class EarthBender extends Bender {

    private double groundSaturation;
    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }

    @Override
    public double getTotalPower() {
        return this.getPower()*this.groundSaturation;
    }

    @Override
    public String toString() {
        return String.format("###Earth Bender: %s, Power: %d, Ground Saturation: %.2f",
                this.getName(), this.getPower(), this.groundSaturation);
    }


}
