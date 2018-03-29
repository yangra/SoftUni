import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02PermutationsWithRepetitionsIterative {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = reader.readLine().split(" ");

        int[] iteration = new int[values.length + 1];
        for (int i = 0; i < iteration.length; i++) {
            iteration[i] = i;
        }

        print(values);

        int i = 1;
        while (i < values.length) {
            iteration[i]--;
            int j;
            if (i % 2 != 0) {
                j = iteration[i];
            } else {
                j = 0;
            }
            if (!values[i].equals(values[j])) {
                swap(j, i, values);
                print(values);
                //i = 1;
            }

            while (iteration[i] == 0) {
                iteration[i] = i;
                i++;
            }
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
