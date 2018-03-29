import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01PermutationsWithoutRepetitionUsed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = reader.readLine().split(" ");
        permute(0, values, new boolean[values.length], new String[values.length]);
    }

    private static void permute(int index, String[] values, boolean[] used, String[] perm) {
        if (index == values.length) {
            print(perm);
        }
        for (int i = 0; i < values.length; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[index] = values[i];
                permute(index + 1, values, used, perm);
                used[i] = false;
            }

        }

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
