import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P02PermutationsWithRepetitionsSwap {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = reader.readLine().split(" ");

        generatePermutations(0,values);
    }

    private static void generatePermutations(int index, String[] values) {
        if (index >= values.length) {
            print(values);
        } else {
            Set<String> swapped = new HashSet<>();
            for (int i = index; i < values.length; i++) {
                if (!swapped.contains(values[i])) {
                    swap(index, i, values);
                    generatePermutations(index + 1, values);
                    swap(index, i, values);
                    swapped.add(values[i]);
                }
            }
        }
    }

    private static void swap(int index, int i, String[] values) {
        String temp = values[index];
        values[index] = values[i];
        values[i] = temp;
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
