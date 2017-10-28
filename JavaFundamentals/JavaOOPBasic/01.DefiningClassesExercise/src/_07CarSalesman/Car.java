package _07CarSalesman;

public class Car {
    private static final String DEFAULT_COLOR = "n/a";
    private static final int DEFAULT_WEIGHT = -1;

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = DEFAULT_WEIGHT;
        this.color = DEFAULT_COLOR;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:\n  %s\n  Weight: %s\n  Color: %s", this.model, this.engine,
                this.weight == -1 ? "n/a" : this.weight, this.color);
    }
}
