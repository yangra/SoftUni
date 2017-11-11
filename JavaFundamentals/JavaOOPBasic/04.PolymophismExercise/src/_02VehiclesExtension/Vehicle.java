package _02VehiclesExtension;

abstract class Vehicle {
    private double tank;
    private double consumption;
    private double tankCapacity;

    protected Vehicle(double tank, double consumption, double tankCapacity) {
        this.setTank(tank);
        this.setConsumption(consumption);
        this.setTankCapacity(tankCapacity);
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getTank() {
        return this.tank;
    }

    private void setTank(double tank) {
        this.tank = tank;
    }

    public double getConsumption() {
        return this.consumption;
    }

    protected void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    void drive(double kilometers){
        if (this.getTank() / this.getConsumption() < kilometers) {
            throw new IllegalArgumentException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
        this.setTank(this.getTank() - (kilometers * this.getConsumption()));
    }

    void refuel(double fuel){
        if(fuel<=0){
            throw  new IllegalArgumentException("Fuel must be a positive number");
        }

        if (fuel > this.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.setTank(this.getTank() + fuel);
    }

    abstract void turnOffConditioner(Visitor visitor);
    abstract void turnOnConditioner(Visitor visitor);

}
