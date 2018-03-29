import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P06CombinationsWithRepetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = reader.readLine().split(" ");
        int n = Integer.parseInt(reader.readLine());
        combine(0, 0, arr, new String[n]);
    }

    private static void combine(int index, int border, String[] set, String[] combination) {
        if(index == combination.length){
            print(combination);
            return;
        }

        for (int i = border; i < set.length; i++) {
            combination[index] = set[i];
            combine(index+1,i,set,combination);
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
