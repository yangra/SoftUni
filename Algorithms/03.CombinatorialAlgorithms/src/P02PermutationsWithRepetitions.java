import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02PermutationsWithRepetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = reader.readLine().split(" ");
        Arrays.sort(values);
        permute(values, 0);
    }

    private static void permute(String[] values, int start) {
        print(values);
        for (int left = values.length - 2; left >= start; left--) {
            for (int right = left + 1; right <= values.length - 1; right++) {
                if (!values[left].equals(values[right])) {
                    swap(left, right, values);
                    permute(values, left + 1);
                }
            }
            String firstElement = values[left];
            for (int i = left; i <= values.length-2; i++) {
                values[i] = values[i+1];
            }
            values[values.length-1] = firstElement;
        }
    }

    private static void swap(int i, int j, String[] values) {
        String temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    private static void print(String[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if (i != values.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
