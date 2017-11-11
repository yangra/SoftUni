package _08May2017.models.benders;

public class AirBender extends Bender {
    private double aerialIntegrity;

    public AirBender(String name, int power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;
    }

    @Override
    public double getTotalPower() {
        return this.getPower()*this.aerialIntegrity;
    }

    @Override
    public String toString() {
        return String.format("###Air Bender: %s, Power: %d, Aerial Integrity: %.2f",
                this.getName(), this.getPower(), this.aerialIntegrity);
    }


}
