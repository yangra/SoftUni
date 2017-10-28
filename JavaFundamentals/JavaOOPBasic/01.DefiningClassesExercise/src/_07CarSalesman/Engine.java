package _07CarSalesman;

public class Engine {
    private static final String DEFAULT_EFFICIENCY = "n/a";
    private static final int DEFAULT_DISPLACEMENT = -1;

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = DEFAULT_DISPLACEMENT;
        this.efficiency = DEFAULT_EFFICIENCY;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s:\n    Power: %d\n    Displacement: %s\n    Efficiency: %s", this.model,
                this.power, this.displacement == -1 ? "n/a" : this.displacement, this.efficiency);
    }
}
