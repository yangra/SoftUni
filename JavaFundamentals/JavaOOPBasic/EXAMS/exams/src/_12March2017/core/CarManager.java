package _12March2017.core;

import _12March2017.entities.cars.Car;
import _12March2017.entities.garage.Garage;
import _12March2017.entities.races.Race;
import _12March2017.factories.CarFactory;
import _12March2017.factories.RaceFactory;

import java.util.HashMap;
import java.util.Map;

public class CarManager {
    private Garage garage;
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;

    public CarManager() {
        this.garage = new Garage();
        this.cars = new HashMap<>();
        this.races = new HashMap<>();
    }

    public void register(int id,
                  String type,
                  String brand,
                  String model,
                  int yearOfProduction,
                  int horsepower,
                  int acceleration,
                  int suspension,
                  int durability) {
        switch (type.toLowerCase()) {
            case "performance":
                Car car = CarFactory.makePerformanceCar(brand,
                        model,
                        yearOfProduction,
                        horsepower,
                        acceleration,
                        suspension,
                        durability);
                cars.put(id, car);
                break;
            case "show":
                car = CarFactory.makeShowCar(brand,
                        model,
                        yearOfProduction,
                        horsepower,
                        acceleration,
                        suspension,
                        durability);
                cars.put(id, car);
                break;
            default:
                break;
        }

    }

    public String check(int id) {
        Car car = cars.get(id);
        return car.toString();
    }

    public void open(int id, String type, int length, String route, int prizePool, int...params) {
        Race race = null;
        switch (type) {
            case "Casual":
                race = RaceFactory.makeCasualRace(length, route, prizePool);
                break;
            case "Drag":
                race = RaceFactory.makeDragRace(length, route, prizePool);
                break;
            case "Drift":
                race = RaceFactory.makeDriftRace(length, route, prizePool);
                break;
            case "TimeLimit":
                race = RaceFactory.makeTimeLimitRace(length, route, prizePool,params[0]);
                break;
            case "Circuit":
                race = RaceFactory.makeCircuitRace(length, route, prizePool,params[0]);
                break;
        }

        this.races.put(id,race);
    }

    public void participate(int carId, int raceId) {
        if(!this.races.containsKey(raceId)){
            return;
        }

        if(!this.cars.containsKey(carId)){
            return;
        }

        if (this.garage.isParked(this.cars.get(carId))) {
            return;
        }

        Race race = this.races.get(raceId);

        if(race.getClass().getSimpleName().equalsIgnoreCase("timelimitrace")&&
                race.getParticipants().size()>0){
            return;
        }

        this.races.get(raceId).addParticipant(this.cars.get(carId));
    }

    public String start(int id) {
        try {
            String result = this.races.get(id).start();
            this.races.remove(id);
            return result;
        } catch (IllegalArgumentException iae) {
            return iae.getMessage();
        }
    }

    public void park(int id) {
        Car car = this.cars.get(id);
        for (Map.Entry<Integer, Race> entry : this.races.entrySet()) {
            if (entry.getValue().isRacer(car)) {
                return;
            }
        }

        this.garage.parkCar(car);
    }

    public void unpark(int id) {
        Car car = this.cars.get(id);
        if (!this.garage.isParked(car)) {
            return;
        }

        this.garage.unparkCar(car);
    }

    public void tune(int tuneIndex, String addOn) {
        this.garage.tune(tuneIndex, addOn);
    }


}
