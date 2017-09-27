import java.util.Arrays;
import java.util.Scanner;

public class P02EncryptSortPrintArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            result[i] = encryptName(name);
        }

        Arrays.sort(result);
        printArray(result);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static int encryptName(String name) {
        String vowels = "AIOUEaioue";
        int sum = 0;
        for (int i = 0; i < name.length(); i++) {
            if (vowels.contains(name.substring(i, i + 1))) {
                sum += (int) name.charAt(i) * name.length();
            } else {
                sum += (int) name.charAt(i) / name.length();
            }
        }

        return sum;
    }
}
