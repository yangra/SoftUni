import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01MergeSort {

    private static int[] aux;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        //long start = System.nanoTime();
        aux = new int[input.length];

        sort(arr, 0, input.length - 1);

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            output.append(arr[i] + " ");
        }
        System.out.println(output);
        //long elapsedTime = System.nanoTime() - start;
        //System.out.println(elapsedTime);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = ((hi - lo) / 2) + lo;

        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void insertionSort(int[] arr, int lo, int hi) {
        if (hi > 0) {
            insertionSort(arr, lo, hi - 1);
            int x = arr[hi];
            int j = hi - 1;
            while (j >= lo && arr[j] > x) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = x;
        }
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        if (arr[mid] < arr[mid + 1]) {
            return;
        }

        for (int index = lo; index <= hi; index++) {
            aux[index] = arr[index];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > hi) {
                arr[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }
    }
}


