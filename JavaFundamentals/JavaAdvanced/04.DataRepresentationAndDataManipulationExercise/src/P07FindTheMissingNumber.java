import java.util.Arrays;
import java.util.Scanner;

public class P07FindTheMissingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        selectionSort(numbers);

        System.out.println(getMissingNumber(numbers, n));


    }

    private static int getMissingNumber(int[] numbers, int n) {
        if(numbers[0]!=1){
            return 1;
        }
        if(numbers[numbers.length-1]!=n){
            return n;
        }

        for (int i = 0; i < numbers.length-1; i++) {
            if(numbers[i+1] - numbers[i] > 1){
                return numbers[i]+1;
            }
        }
        return 0;
    }

    private static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int min = i;
            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[min]>numbers[j]){
                    min = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[min];
            numbers[min] = temp;
        }
    }
}
