import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02RecursiveFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int limit = Integer.parseInt(reader.readLine());

        System.out.println(factorial(1, limit));
    }

    private static long factorial(int current, int limit) {
        if (current > limit) {
            return 1;
        }

        long result = current * factorial(current + 1, limit);
        return result;
    }
}
