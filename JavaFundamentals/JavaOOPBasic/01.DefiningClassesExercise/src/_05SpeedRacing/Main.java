package _05SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCars = Integer.parseInt(reader.readLine());

        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] params = reader.readLine().split("\\s+");
            Car car = new Car(params[0], Double.parseDouble(params[1]), Double.parseDouble(params[2]));
            cars.put(params[0], car);
        }

        while (true) {
            String[] drive = reader.readLine().split("\\s+");
            if ("end".equalsIgnoreCase(drive[0])) {
                break;
            }
            try {
                cars.get(drive[1]).drive(Integer.parseInt(drive[2]));
            } catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
            }
        }

        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
