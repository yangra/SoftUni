package P08;


public interface Vehicle {
    void drive(Double km);
    void refuel(Double litres);
    boolean canTravel(Double km);
    Double getQuantity();
}
