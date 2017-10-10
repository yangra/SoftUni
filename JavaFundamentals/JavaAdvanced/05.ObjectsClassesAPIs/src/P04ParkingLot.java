import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P04ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parkingLot = new HashSet<>();
        while (true) {
            String line = scanner.nextLine();
            if ("END".equals(line)) {
                break;
            }

            String[] transition = line.split(", ");
            if ("IN".equals(transition[0])) {
                parkingLot.add(transition[1]);
            } else {
                parkingLot.remove(transition[1]);
            }
        }

        if (!parkingLot.isEmpty()) {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        }else{
            System.out.println("Parking Lot is Empty");
        }
    }
}
