import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03VariationsWithoutRepetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = reader.readLine().split(" ");
        int n = Integer.parseInt(reader.readLine());
        variate(0, arr, new String[n], new boolean[arr.length]);
    }

    private static void variate(int index, String[] set, String[] variation, boolean[] used) {
        if (index == variation.length) {
            print(variation);
            return;
        }

        for (int i = 0; i < set.length; i++) {
            if (!used[i]) {
                variation[index] = set[i];
                used[i] = true;
                variate(index + 1, set, variation, used);
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
