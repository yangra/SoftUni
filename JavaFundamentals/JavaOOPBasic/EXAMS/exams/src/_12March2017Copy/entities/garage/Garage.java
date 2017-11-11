package _12March2017Copy.entities.garage;

import _12March2017Copy.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public void parkCar(Car car){
        this.parkedCars.add(car);
    }

    public void unparkCar(Car car){
        this.parkedCars.remove(car);
    }

    public List<Car> getParkedCars() {
        return Collections.unmodifiableList(this.parkedCars);
    }

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

}
