package _08May2017.models.monuments;

public class WaterMonument extends Monument {
    private int waterAffinity;

    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }

    @Override
    public String toString() {
        return String.format("###Water Monument: %s, Water Affinity: %d",this.getName(), this.waterAffinity);
    }

    @Override
    public int getAffinity() {
        return this.waterAffinity;
    }
}
