package _06RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        setTires(tires);
    }

    public void setTires(Tire[] tires) {
        if(tires.length==4){
           this.tires = tires;
        }else{
            throw new IllegalStateException("Invalid number of tires");
        }
    }

    @Override
    public String toString() {
        return String.format("%s", this.model);
    }
}
