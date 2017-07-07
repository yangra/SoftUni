package P08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;


public class Main {
    private static Vehicle car;
    private static Vehicle truck;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = reader.readLine().split("\\s");
        String[] truckInfo = reader.readLine().split("\\s");
        car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));
        int moves = Integer.parseInt(reader.readLine());
        for (int i = 0; i < moves; i++) {
            String[] command = reader.readLine().split("\\s");
            if (command.length == 3) {
                if ("Drive".equals(command[0])) {
                    drive(command[1], Double.parseDouble(command[2]));
                } else {
                    refuel(command[1], Double.parseDouble(command[2]));
                }
            }
        }
        System.out.printf("Car: %.2f\n", car.getQuantity());
        System.out.printf("Truck: %.2f\n", truck.getQuantity());
    }

    private static void drive(String type, Double km) {
        DecimalFormat decimalFormat = new DecimalFormat("0.########");
        switch (type) {
            case "Car":
                if (car.canTravel(km)) {
                    car.drive(km);
                    System.out.printf("Car travelled %s km\n", decimalFormat.format(km));
                } else {
                    System.out.println("Car needs refueling");
                }
                break;
            case "Truck":
                if (truck.canTravel(km)) {
                    truck.drive(km);
                    System.out.printf("Truck travelled %s km\n", decimalFormat.format(km));
                } else {
                    System.out.println("Truck needs refueling");
                }
                break;
        }
    }

    private static void refuel(String type, Double litres) {
        switch (type) {
            case "Car":
                car.refuel(litres);
                break;
            case "Truck":
                truck.refuel(litres);
                break;
        }
    }
}
