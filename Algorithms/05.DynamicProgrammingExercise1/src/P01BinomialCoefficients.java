import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01BinomialCoefficients {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        if (k > n) {
            throw new IllegalArgumentException();
        }

        Map<Integer, Map<Integer, Long>> values = new HashMap<>();
        long result = binomialCoef(n, k, values);
        System.out.println(result);
    }

    private static long binomialCoef(int n, int k, Map<Integer, Map<Integer, Long>> values) {
        if (values.containsKey(n) && values.get(n).containsKey(k)) {
            return values.get(n).get(k);
        }

        if (n == k || k == 0) {
            values.putIfAbsent(n, new HashMap<>());
            values.get(n).putIfAbsent(k, 1L);
            return 1;
        }

        long coef = binomialCoef(n - 1, k - 1, values) + binomialCoef(n - 1, k, values);
        values.putIfAbsent(n, new HashMap<>());
        values.get(n).putIfAbsent(k, coef);
        values.get(n).putIfAbsent(n - k, coef);
        return coef;
    }
}
