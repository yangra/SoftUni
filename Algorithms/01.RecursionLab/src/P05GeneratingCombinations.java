import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P05GeneratingCombinations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] elements = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = Integer.parseInt(reader.readLine());
        int[] comb = new int[length];
        generate(0, 0, elements, comb);
    }

    private static void generate(int index, int limit, int[] elements, int[] combination) {
        if (index >= combination.length) {
            Arrays.stream(combination).forEach(n-> System.out.print(n+" "));
            System.out.println();
            return;
        }

        for (int i = limit; i < elements.length; i++) {
            combination[index] = elements[i];
            generate(index + 1, i+1, elements, combination);

        }
    }
}
