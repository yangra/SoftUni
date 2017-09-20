import java.util.Arrays;
import java.util.Scanner;

public class P08GetFirstOddOrEvenElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] command = scanner.nextLine().split("\\s+");
        int numberOfElements = Integer.parseInt(command[1]);
        String type = command[2];

        if (type.equals("odd")) {
            printResult(1, numberOfElements, array);
        } else if (type.equals("even")) {
            printResult(0, numberOfElements, array);
        }
    }

    private static void printResult(int type, int numberOfElements, int[] array) {
        int counter = 0;
        int iter = 0;
        while (counter < numberOfElements && iter < array.length) {
            if (Math.abs(array[iter]) % 2 == type) {
                System.out.print(array[iter] + " ");
                counter++;
            }
            iter++;
        }
    }
}
