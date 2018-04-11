import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P04SumWithUnlimitedCoins {
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
            while (currentSum < sum) {
                currentSum += coins[i];
                if (currentSum <= sum) {
                    currentSums.add(currentSum);
                }
            }

            sums.add(currentSums);
        }
        //List<Integer> combination = new ArrayList<>();
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
//            System.out.println(comb);
//            System.out.println(sums);
            return ++combinations;
        }
        if (sums.size() == 0) {
            return combinations;
        }

        List<Integer> currentSums = sums.get(0);
        for (int i = 0; i < currentSums.size(); i++) {
//            comb.add(currentSums.get(i));
            if (currentSum + currentSums.get(i) == sum) {
//                System.out.println(comb);
//                System.out.println(sums);
//                comb.remove(comb.size() - 1);
                return ++combinations;
            }
            for (int j = 0; j < sums.size() - 1; j++) {
                combinations = combine(currentSum + currentSums.get(i), sum, sums.subList(j + 1, sums.size()));
            }
//            comb.remove(comb.size() - 1);
        }

        return combinations;
    }
}