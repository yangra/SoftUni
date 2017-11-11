package _12March2017Copy.factories;

import _12March2017Copy.entities.cars.Car;
import _12March2017Copy.entities.cars.PerformanceCar;
import _12March2017Copy.entities.cars.ShowCar;

public final class CarFactory {

    private CarFactory(){}

    public static Car makePerformanceCar(String brand,
                                            String model,
                                            int yearOfProduction,
                                            int horsepower,
                                            int acceleration,
                                            int suspension,
                                            int durability) {
        return new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        
    }

    public static Car makeShowCar(String brand,
                                  String model,
                                  int yearOfProduction,
                                  int horsepower,
                                  int acceleration,
                                  int suspension,
                                  int durability) {
        return new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        
    }
}
