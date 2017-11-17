package _03Ferrari;

public class Ferrari implements Car {
    private String model;
    private String driver;

    public Ferrari(String driver) {
        this.model = "488-Spider";
        this.driver = driver;
    }

    public String pushBrakes() {
        return "Brakes!";
    }

    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",this.model,this.pushBrakes(), this.pushGasPedal(), this.driver);
    }
}
