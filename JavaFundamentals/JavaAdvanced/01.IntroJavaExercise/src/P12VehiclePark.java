import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P12VehiclePark {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] vehicles = scanner.nextLine().split("\\s+");
        List<String> park = new ArrayList<>(Arrays.asList(vehicles));

        int counterSold = 0;
        while (true) {
            String customer = scanner.nextLine();
            if (customer.equals("End of customers!")) {
                break;
            }

            String[] params = customer.split("\\s+");
            int seats = Integer.parseInt(params[2]);
            String query = params[0].toLowerCase().charAt(0) + "" + seats;

            if (park.contains(query)) {
                int price = query.charAt(0) * seats;
                park.remove(query);
                System.out.printf("Yes, sold for %d$%n", price);
                counterSold++;
            } else {
                System.out.printf("No%n");
            }
        }

        StringBuilder vehiclesLeft = new StringBuilder();
        for (int i = 0; i < park.size(); i++) {
            vehiclesLeft.append(park.get(i));
            if (i < park.size() - 1) {
                vehiclesLeft.append(", ");
            }
        }

        System.out.printf("Vehicles left: %s%n", vehiclesLeft);
        System.out.printf("Vehicles sold: %d%n", counterSold);
    }

}
