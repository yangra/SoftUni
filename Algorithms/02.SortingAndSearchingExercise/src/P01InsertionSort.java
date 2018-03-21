import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01InsertionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        long start = System.nanoTime();

        sort(arr, input.length-1 );

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            output.append(arr[i] + " ");
        }
        System.out.println(output);
        long elapsedTime = System.nanoTime() - start;
        System.out.println(elapsedTime);
    }

    private static void sort(int[] arr,  int n) {
        if (n > 0) {
            sort(arr, n - 1);
            int x = arr[n];
            int j = n - 1;
            while (j >= 0 && arr[j] > x) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = x;
        }
    }
}
