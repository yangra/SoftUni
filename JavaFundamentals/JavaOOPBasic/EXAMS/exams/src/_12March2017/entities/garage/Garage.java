package _12March2017.entities.garage;

import _12March2017.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public void parkCar(Car car){
        this.parkedCars.add(car);
    }

    public void unparkCar(Car car){
        this.parkedCars.remove(car);
    }



    public void tune(int tuneIndex, String addOn){
        this.parkedCars.stream().forEach(c->c.tune(tuneIndex,addOn));
    }

    public boolean isParked(Car car){
        if(this.parkedCars.contains(car)){
            return true;
        }
        return false;
    }




}
