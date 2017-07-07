package P08;


public abstract class VehicleImpl implements Vehicle {
    private Double quantity;
    private Double consumption;

    @Override
    public Double getQuantity() {
        return this.quantity;
    }

    protected VehicleImpl(Double quantity, Double consumption) {
        this.quantity = quantity;
        this.consumption = consumption;
    }

    @Override
    public void drive(Double km) {
        if (this.canTravel(km)) {
            this.quantity -= km * consumption;
        }
    }

    @Override
    public void refuel(Double litres) {
        this.quantity +=litres;
    }

    @Override
    public boolean canTravel(Double km) {
        return this.consumption * km <= quantity;
    }
}
