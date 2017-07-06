package P08;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfIncreasingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(a -> Integer.parseInt(a)).toArray();
        int maxLength = 1;
        int currentLength = 1;
        int currentStart = 0;
        int maxStart = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                currentLength++;
                if (currentLength == 2) {
                    currentStart = i;
                }
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStart = currentStart;
                }
            } else {
                currentLength = 1;
            }
        }

        for (int i = 0; i < maxLength; i++) {
            System.out.print(arr[maxStart + i] + " ");
        }
    }
}
