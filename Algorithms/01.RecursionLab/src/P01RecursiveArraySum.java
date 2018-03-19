import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01RecursiveArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(sum(0, array));
    }

    private static long sum(int index, int[] array) {
        if (index == array.length) {
            return 0;
        }

        long sum = array[index] + sum(index + 1, array);
        return sum;
    }
}
