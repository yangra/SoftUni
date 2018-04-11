import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02LongestZigzagSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (numbers.length == 0) {
            return;
        }

        int[] bestLength = new int[numbers.length];
        int[] prevIndex = new int[numbers.length];

        bestLength[0] = 1;
        prevIndex[0] = -1;
        if (numbers[1] != numbers[0]) {
            bestLength[1] = 2;
            prevIndex[1] = 0;
        } else {
            bestLength[1] = bestLength[0];
            prevIndex[1] = -1;
        }

        int maxLength = bestLength[1];
        int maxIndex = 1;
        for (int i = 2; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (prevIndex[j] != -1 && bestLength[j] >= bestLength[i] && (numbers[i] > numbers[j]
                        && numbers[j] < numbers[prevIndex[j]] ||
                        numbers[i] < numbers[j]
                                && numbers[j] > numbers[prevIndex[j]])) {
                    bestLength[i] = bestLength[j] + 1;
                    prevIndex[i] = j;
                }else if(prevIndex[j]==-1&& bestLength[j] >= bestLength[i]&& (numbers[i] != numbers[j])){
                    bestLength[i] = bestLength[j] + 1;
                    prevIndex[i] = j;
                }
            }
            if (bestLength[i] > maxLength) {
                maxLength = bestLength[i];
                maxIndex = i;
            }
        }

        int[] result = new int[maxLength];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = numbers[maxIndex];
            maxIndex = prevIndex[maxIndex];
        }

        Arrays.stream(result).forEach(n -> System.out.print(n + " "));
    }
}
