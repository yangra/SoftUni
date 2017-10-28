package _07CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Car> cars = new ArrayList<>();
        Map<String, Engine> engines = new HashMap<>();
        int numberOfEngines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfEngines; i++) {
            String[] engineParams = reader.readLine().split("\\s+");
            Engine engine = new Engine(engineParams[0], Integer.parseInt(engineParams[1]));
            if (engineParams.length == 3) {
                try {
                    int displacement = Integer.parseInt(engineParams[2]);
                    engine.setDisplacement(displacement);
                } catch (NumberFormatException nfe) {
                    engine.setEfficiency(engineParams[2]);
                }
            } else if (engineParams.length == 4) {
                int displacement = Integer.parseInt(engineParams[2]);
                engine.setDisplacement(displacement);
                engine.setEfficiency(engineParams[3]);
            }

            engines.put(engineParams[0], engine);
        }

        int numberOfCars = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] carParams = reader.readLine().split("\\s+");
            Car car = new Car(carParams[0], engines.get(carParams[1]));
            if (carParams.length == 3) {
                try {
                    int weight = Integer.parseInt(carParams[2]);
                    car.setWeight(weight);
                } catch (NumberFormatException nfe) {
                    car.setColor(carParams[2]);
                }
            } else if (carParams.length == 4) {
                int weight = Integer.parseInt(carParams[2]);
                car.setWeight(weight);
                car.setColor(carParams[3]);
            }
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car);
        }

    }
}
