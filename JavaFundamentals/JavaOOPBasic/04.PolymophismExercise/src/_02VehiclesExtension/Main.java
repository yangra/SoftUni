package _02VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carParams = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carParams[1]), Double.parseDouble(carParams[2]), Double.parseDouble(carParams[3]));
        String[] truckParams = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckParams[1]), Double.parseDouble(truckParams[2]), Double.parseDouble(truckParams[3]));
        String[] busParams = reader.readLine().split("\\s+");
        Vehicle bus = new Bus(Double.parseDouble(busParams[1]), Double.parseDouble(busParams[2]), Double.parseDouble(busParams[3]));
        Map<String, Vehicle> vehicles = new HashMap<>();
        vehicles.put("car", car);
        vehicles.put("truck", truck);
        vehicles.put("bus", bus);
        Visitor visitor = new Visitor();

        DecimalFormat df = new DecimalFormat("#.##");
        int numberOfCommands = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = reader.readLine().split("\\s+");
            switch (command[0].toLowerCase()) {
                case "drive":
                    double kilometers = Double.parseDouble(command[2]);
                    Vehicle vehicle = vehicles.get(command[1].toLowerCase());
                    try {
                        vehicle.drive(kilometers);
                        System.out.printf("%s travelled %s km\n", vehicle.getClass().getSimpleName(), df.format(kilometers));
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "refuel":
                    double fuel = Double.parseDouble(command[2]);
                    try {
                        vehicles.get(command[1].toLowerCase()).refuel(fuel);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "driveempty":
                    kilometers = Double.parseDouble(command[2]);
                    vehicle = vehicles.get(command[1].toLowerCase());
                    vehicle.turnOffConditioner(visitor);
                    try {
                        vehicle.drive(kilometers);
                        System.out.printf("%s travelled %s km\n", vehicle.getClass().getSimpleName(), df.format(kilometers));
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    vehicle.turnOnConditioner(visitor);
                default:
                    break;
            }
        }

        System.out.printf("Car: %.2f\n", car.getTank());
        System.out.printf("Truck: %.2f\n", truck.getTank());
        System.out.printf("Bus: %.2f\n", bus.getTank());
    }

}
