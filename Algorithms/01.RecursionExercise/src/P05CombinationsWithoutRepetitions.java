import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P05CombinationsWithoutRepetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int setSize = Integer.parseInt(reader.readLine());
        int[] set = new int[setSize];
        int val = 1;
        for (int i = 0; i < set.length; i++) {
            set[i] = val++;
        }
        int count = Integer.parseInt(reader.readLine());

        StringBuilder output = new StringBuilder();
        combine(0,0, set, new int[count], output);
        System.out.print(output.toString());
    }

    private static void combine(int index,int border, int[] set, int[] comb, StringBuilder out) {
        if (index >= comb.length) {
            Arrays.stream(comb).forEach(v -> out.append(v + " "));
            out.append('\n');
            return;
        }


        for (int j = border; j < set.length; j++) {
            comb[index] = set[j];
            combine(index + 1,j+1, set, comb, out);
        }
    }
}
