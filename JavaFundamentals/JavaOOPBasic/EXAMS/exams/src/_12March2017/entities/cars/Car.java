package _12March2017.entities.cars;

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

    protected int getHorsepower() {
        return this.horsepower;
    }

    protected int getAcceleration() {
        return this.acceleration;
    }

    protected int getSuspension() {
        return this.suspension;
    }

    protected int getDurability() {
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
        this.setHorsepower(this.getHorsepower() + tuneIndex);
        this.setSuspension(this.getSuspension() + (tuneIndex / 2));
    }

    public int getEnginePerformance(){
        return (this.getHorsepower() / this.getAcceleration());
    }

    public  int getSuspensionPerformance(){
        return (this.getSuspension() + this.getDurability());
    }

    public int getOverallPerformance(){
        return (this.getHorsepower() / this.getAcceleration()) + (this.getSuspension() + this.getDurability());
    }

    public int getTimePerformanceIndex(){
        return ((this.horsepower/100)*this.acceleration);
    }

    public void decreaseDurability(int number){
        this.setDurability(this.getDurability() - number);
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
