import java.util.Arrays;
import java.util.Scanner;

public class P05OddAndEvenPairs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (array.length % 2 != 0) {
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < array.length; i += 2) {
            if (array[i] % 2 == 0 && array[i + 1] % 2 == 0) {
                System.out.printf("%d, %d -> both are even%n", array[i], array[i+1]);
            } else if (array[i] % 2 != 0 && array[i+1] % 2 != 0) {
                System.out.printf("%d, %d -> both are odd%n", array[i], array[i+1]);
            } else {
                System.out.printf("%d, %d -> different%n", array[i], array[i+1]);
            }
        }

    }
}
