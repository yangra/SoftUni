package _01Vehicles;

public class Visitor {


    void drive(Truck truck,double kilometers){
        truck.drive(kilometers);
    }

    void drive(Car car,double kilometers){
        car.drive(kilometers);
    }

    void refuel(Truck truck,double fuel){
        truck.refuel(fuel);
    }

    void refuel(Car car,double fuel){
        car.refuel(fuel);
    }


}
