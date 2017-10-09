import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P03RecursiveArraySum {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = recursiveSum(array,0);
        System.out.println(sum);
    }

    private static int recursiveSum(int[] array, int i) {
        if(i>=array.length){
            return 0;
        }
        return array[i] + recursiveSum(array,i+1);
    }
}
