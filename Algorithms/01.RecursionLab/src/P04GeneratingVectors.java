import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P04GeneratingVectors {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());

        int[] arr = new int[length];
        generate(0, 2, arr);
    }

    private static void generate(int index, int i, int[] arr) {
        if (index >= arr.length) {
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println();
            return;
        }
        for (int j = 0; j < i; j++) {
            arr[index] = j;
            generate(index + 1, i, arr);
        }
    }
}
