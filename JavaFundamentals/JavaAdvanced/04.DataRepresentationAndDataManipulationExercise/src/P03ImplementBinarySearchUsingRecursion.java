import java.util.Arrays;
import java.util.Scanner;


public class P03ImplementBinarySearchUsingRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sorted = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int search = Integer.parseInt(scanner.nextLine());

        binarySearch(sorted, 0, sorted.length - 1, search);

    }

    private static void binarySearch(int[] array, int indexStart, int indexEnd, int key) {
        if (indexStart <= indexEnd) {
            int middle = (indexStart + indexEnd) / 2;
            if (key < array[middle]) {
                binarySearch(array, indexStart, middle - 1, key);
            } else if (key > array[middle]) {
                binarySearch(array, middle + 1, indexEnd, key);
            } else {
                System.out.println(middle);
            }

        } else {
            System.out.println(-1);
        }
    }
}
