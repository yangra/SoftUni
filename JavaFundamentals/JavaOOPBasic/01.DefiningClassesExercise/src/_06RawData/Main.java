package _06RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Car> flammable = new ArrayList<>();
        List<Car> fragile = new ArrayList<>();
        int numberOfCars = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] params = reader.readLine().split("\\s+");
            double airPressureTire1 = Double.parseDouble(params[5]);
            double airPressureTire2 = Double.parseDouble(params[7]);
            double airPressureTire3 = Double.parseDouble(params[9]);
            double airPressureTire4 = Double.parseDouble(params[11]);
            int enginePower = Integer.parseInt(params[2]);
            if (params[4].equals("fragile") &&
                    (airPressureTire1 < 1 || airPressureTire2 < 1 ||
                            airPressureTire3 < 1 || airPressureTire4 < 1)) {
                Car car = createNewCar(params, airPressureTire1, airPressureTire2, airPressureTire3, airPressureTire4, enginePower);
                fragile.add(car);

            } else if (params[4].equals("flamable") && enginePower > 250) {
                Car car = createNewCar(params, airPressureTire1, airPressureTire2, airPressureTire3, airPressureTire4, enginePower);
                flammable.add(car);
            }
        }

        String query = reader.readLine();
        if (query.equals("flamable")) {
            for (Car car : flammable) {
                System.out.println(car);
            }
        } else {
            for (Car car : fragile) {
                System.out.println(car);
            }
        }
    }

    private static Car createNewCar(String[] params, double airPressureTire1, double airPressureTire2, double airPressureTire3, double airPressureTire4, int enginePower) {
        Engine engine = new Engine(Integer.parseInt(params[1]), enginePower);
        Cargo cargo = new Cargo(Integer.parseInt(params[3]), params[4]);
        Tire[] tires = new Tire[4];
        tires[0] = new Tire(airPressureTire1, Integer.parseInt(params[6]));
        tires[1] = new Tire(airPressureTire2, Integer.parseInt(params[8]));
        tires[2] = new Tire(airPressureTire3, Integer.parseInt(params[10]));
        tires[3] = new Tire(airPressureTire4, Integer.parseInt(params[12]));
        return new Car(params[0], engine, cargo, tires);
    }
}
