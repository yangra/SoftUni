import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] bestLength = new int[numbers.length];
        int[] prevIndex = new int[numbers.length];

        int maxLengthIndex = -1;
        int maxLength = 0;
        for (int current = 0; current < numbers.length; current++) {
            bestLength[current] = 1;
            prevIndex[current] = -1;
            for (int best = 0; best < current; best++) {
                if (numbers[current] > numbers[best] && bestLength[best] + 1 > bestLength[current]) {
                    bestLength[current] = bestLength[best] + 1;
                    prevIndex[current] = best;
                }
            }

            if (maxLength < bestLength[current]) {
                maxLength = bestLength[current];
                maxLengthIndex = current;
            }
        }

        int[] result = new int[maxLength];
        int prev = maxLengthIndex;
        int index = maxLength - 1;
        while (prev != -1) {
            result[index] = numbers[prev];
            prev = prevIndex[prev];
            index--;
        }

        Arrays.stream(result).forEach(e->System.out.print(e+" "));
    }
}
