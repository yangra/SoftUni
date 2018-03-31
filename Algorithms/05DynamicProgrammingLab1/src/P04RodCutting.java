import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P04RodCutting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] prices = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int length = Integer.parseInt(reader.readLine());
        int[] bestPrice = new int[prices.length];
        bestPrice[1] = 1;
        int[] bestPart = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= i; j++) {
                int leftover = i % j;
                int times = i / j;
                int currentPrice;
                if (leftover == 0&&times==1) {
                    currentPrice = prices[i];
                } else {
                    currentPrice = times * bestPrice[j] +  bestPrice[leftover];
                }
                if (currentPrice > bestPrice[i]) {
                    bestPrice[i] = currentPrice;
                    bestPart[i] = j;
                }
            }
        }

        int maxPrice = 0;
        int part = -1;
        for (int i = 1; i <= length; i++) {
            int leftover = length % i;
            int times = length / i;
            int currentPrice = times * bestPrice[i] + bestPrice[leftover];
            if (currentPrice > maxPrice) {
                maxPrice = currentPrice;
                part = i;
            }
        }

        List<Integer> result= new ArrayList<>();
        System.out.println(maxPrice);
        for (int i = 0; i < length / part; i++) {
            result.add(part);
        }

        while (length % part != 0) {
            length = length % part;
            part = bestPart[length % part];
            for (int i = 0; i < length / part; i++) {
                result.add(part);
            }
        }

        for (int i = result.size()-1; i >= 0; i--) {
            System.out.print(result.get(i));
            if(i!=0){
                System.out.print(" ");
            }
        }
    }
}
