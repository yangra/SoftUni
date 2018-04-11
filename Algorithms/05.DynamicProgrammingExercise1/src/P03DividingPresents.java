import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P03DividingPresents {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = Arrays.stream(numbers).sum();

        int[] sums = new int[sum + 1];

        for (int i = 1; i < sums.length; i++) {
            sums[i] = -1;
        }

        for (int index = 0; index < numbers.length; index++) {
            for (int prevSumIndex = sum - numbers[index]; prevSumIndex >= 0; prevSumIndex--) {
                int presentValue = numbers[index];
                if (sums[prevSumIndex] != -1 && sums[prevSumIndex + presentValue] == -1) {
                    sums[prevSumIndex + presentValue] = index;
                }
            }
        }

        int halfSum = sum / 2;
        int bestSumIndex = -1;
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < sums.length; i++) {
            if (halfSum - i < diff && halfSum - i >= 0&& sums[i]!=-1) {
                bestSumIndex = i;
                diff = halfSum - i;
            }
        }

        List<String> result = new ArrayList<>();
        int index = bestSumIndex;
        while (index != 0) {
            int num = numbers[sums[index]];
            result.add(Integer.toString(num));
            index -= num;
        }

        System.out.printf("Difference: %d\n", sum-2*bestSumIndex);
        System.out.printf("Alan:%d Bob:%d\n", bestSumIndex, sum - bestSumIndex);
        System.out.printf("Alan takes: %s\n", String.join(" ", result));
        System.out.println("Bob takes the rest.");
    }
}
