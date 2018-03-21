import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02NestedLoops {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();
        simulateLoops(0, new int[num], output);
        System.out.print(output.toString());
    }

    private static void simulateLoops(int index, int[] round, StringBuilder output) {
        if (index == round.length) {
            Arrays.stream(round).forEach(n -> output.append(n + " "));
            output.append('\n');
            return;
        }

        for (int i = 0; i < round.length; i++) {
            round[index] = i + 1;
            simulateLoops(index + 1, round, output);
        }
    }
}
