package _12March2017Copy.entities.cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.setBrand(brand);
        this.setModel(model);
        this.setYearOfProduction(yearOfProduction);
        this.setHorsepower(horsepower);
        this.setAcceleration(acceleration);
        this.setSuspension(suspension);
        this.setDurability(durability);
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public int getSuspension() {
        return this.suspension;
    }

    public int getDurability() {
        return this.durability;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    private void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    public void tune(int tuneIndex, String tuneAddOn) {
        this.horsepower += tuneIndex;
        this.suspension += tuneIndex / 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %d\n", this.brand, this.model, this.yearOfProduction));
        sb.append(String.format("%d HP, 100 m/h in %d s\n", this.horsepower, this.acceleration));
        sb.append(String.format("%d Suspension force, %d Durability\n", this.suspension, this.durability));
        return sb.toString();
    }
}
