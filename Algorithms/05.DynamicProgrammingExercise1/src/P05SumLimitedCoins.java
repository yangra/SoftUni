import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P05SumLimitedCoins {
    private static int combinations = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int[] coins = new int[input.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(input[i]);
        }
        int sum = Integer.parseInt(reader.readLine());

        Arrays.sort(coins);


        List<List<Integer>> sums = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            int currentSum = 0;
            List<Integer> currentSums = new ArrayList<>();

            if (currentSum <= sum) {
                currentSum += coins[i];
                if (currentSum <= sum) {
                    currentSums.add(currentSum);
                }
                while (i < coins.length - 1 && coins[i] == coins[i + 1]) {
                    i++;
                    currentSum += coins[i];
                    if (currentSum <= sum) {
                        currentSums.add(currentSum);
                    }
                }
            }

            sums.add(currentSums);
        }

        for (int i = 0; i < sums.size(); i++) {
            combinations = combine(0, sum, sums.subList(i, sums.size()));
        }
        System.out.println(combinations);

    }

    private static int combine(int currentSum, int sum, List<List<Integer>> sums) {
        if (currentSum > sum) {
            return combinations;
        }
        if (currentSum == sum) {
            return ++combinations;
        }
        if (sums.size() == 0) {
            return combinations;
        }

        List<Integer> currentSums = sums.get(0);
        for (int i = 0; i < currentSums.size(); i++) {
            if (currentSum + currentSums.get(i) == sum) {

                return ++combinations;
            }
            for (int j = 0; j < sums.size() - 1; j++) {
                combinations = combine(currentSum + currentSums.get(i), sum, sums.subList(j + 1, sums.size()));
            }
        }

        return combinations;
    }
}
