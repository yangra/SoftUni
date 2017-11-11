package _08May2017.models.monuments;

public class AirMonument extends Monument {
    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    @Override
    public String toString() {
        return String.format("###Air Monument: %s, Air Affinity: %d",this.getName(), this.airAffinity);
    }

    @Override
    public int getAffinity() {
        return this.airAffinity;
    }
}
