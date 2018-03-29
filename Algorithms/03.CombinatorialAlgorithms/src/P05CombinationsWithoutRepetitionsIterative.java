import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class P05CombinationsWithoutRepetitionsIterative {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> values = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        int k = Integer.parseInt(reader.readLine());


        String[] combination = new String[k];
        Deque<Integer> stack = new ArrayDeque<>();
        int valueIndex = 0;
        stack.push(valueIndex);

        while (stack.size() > 0) {
            valueIndex = stack.pop();
            int index = stack.size();

            while (valueIndex < values.size()) {
                combination[index++] = values.get(valueIndex++);
                stack.push(valueIndex);
                if (index == k) {
                    print(combination);
                    break;
                }
            }
        }
    }

    private static void print(String[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if (i != values.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

    }
}


