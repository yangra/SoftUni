package _08May2017.models.benders;

public abstract class Bender {
    private  String name;
    private int power;

    protected Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    protected String getName() {
        return this.name;
    }

    public int getPower() {
        return this.power;
    }

    public abstract double getTotalPower();
}
