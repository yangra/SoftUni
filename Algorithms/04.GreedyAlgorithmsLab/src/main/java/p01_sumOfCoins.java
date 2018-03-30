import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p01_sumOfCoins {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(reader.readLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
        System.out.printf("Number of coins to take: %d\n", usedCoins.values().stream().reduce((a, b) -> a + b));
        for (Map.Entry<Integer, Integer> entry : usedCoins.entrySet()) {
            System.out.printf("%d coin(s) with value %d\n", entry.getValue(), entry.getKey());
        }

    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Arrays.sort(coins);
        int index = coins.length - 1;
        Map<Integer,Integer> result = new LinkedHashMap<>();
        while (targetSum > 0) {
            if (targetSum - coins[index] >= 0) {
                result.putIfAbsent(coins[index],0);
                result.put(coins[index], result.get(coins[index])+1);
                targetSum -= coins[index];
            }else{
                index--;
                if(index<0){
                    throw new IllegalArgumentException();
                }
            }
        }
        return result;
    }
}
