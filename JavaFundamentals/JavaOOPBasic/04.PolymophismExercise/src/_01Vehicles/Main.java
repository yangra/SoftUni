package _01Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carParams = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carParams[1]), Double.parseDouble(carParams[2]));
        String[] truckParams = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckParams[1]), Double.parseDouble(truckParams[2]));
        Visitor visitor = new Visitor();


        DecimalFormat df = new DecimalFormat("#.##");
        int numberOfCommands = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = reader.readLine().split("\\s+");
            switch (command[0].toLowerCase()) {
                case "drive":
                    double kilometers = Double.parseDouble(command[2]);
                    if ("Car".equalsIgnoreCase(command[1])) {
                        drive(visitor, car, df, kilometers);
                    } else if("Truck".equalsIgnoreCase(command[1])) {
                        drive(visitor, truck, df, kilometers);
                    }
                    break;
                case "refuel":
                    double fuel = Double.parseDouble(command[2]);
                    if ("Car".equalsIgnoreCase(command[1])) {
                        refuel(visitor, car, fuel);
                    } else {
                        refuel(visitor, truck, fuel);
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.printf("Car: %.2f\n", car.getTank());
        System.out.printf("Truck: %.2f\n", truck.getTank());
    }

    private static void refuel(Visitor visitor, Vehicle vehicle, double fuel) {
        try {
            vehicle.refuel(visitor, fuel);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void drive(Visitor visitor, Vehicle vehicle, DecimalFormat df, double kilometers) {
        try {
            vehicle.drive(visitor, kilometers);
            System.out.printf("%s travelled %s km\n", vehicle.getClass().getSimpleName(), df.format(kilometers));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
