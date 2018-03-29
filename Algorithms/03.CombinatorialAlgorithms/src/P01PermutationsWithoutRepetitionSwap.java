import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01PermutationsWithoutRepetitionSwap {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = reader.readLine().split(" ");
        permute(0, values);
    }


    private static void permute(int index, String[] elements) {
        if (index == elements.length) {
            print(elements);
            return;
        }

        permute(index + 1, elements);
        for (int i = index + 1; i < elements.length; i++) {
            swap(i, index, elements);
            permute(index + 1, elements);
            swap(i, index, elements);
        }
    }

    private static void swap(int i, int index, String[] values) {
        String temp = values[i];
        values[i] = values[index];
        values[index] = temp;
    }


    private static void print(String[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if(i!= values.length-1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }

}
