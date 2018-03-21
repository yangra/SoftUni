import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P01QuickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        sort(arr, 0, arr.length - 1);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.length ; i++) {
            output.append(arr[i]+" ");
        }
        System.out.println(output);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int p = partition(arr, lo, hi);
        sort(arr, lo, p - 1);
        sort(arr, p + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return lo;
        }

        int i = lo;
        int j = hi + 1;
        while (true) {
            while (arr[++i] < arr[lo]) {
                if (i == hi) break;
            }

            while (arr[lo] < arr[--j]) {
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(arr, i, j);
        }

        swap(arr, lo, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
