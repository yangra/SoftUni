import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P03InversionCount2 {

    private static int[] aux;
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        aux = new int[input.length];

        sort(arr, 0, input.length - 1);

        System.out.println(count);
    }

    private static void sort(int[] arr, int lo, int hi) {

        if(lo>=hi){
            return;
        }

        int mid = (hi + lo) / 2;

        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
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
            } else if (aux[i] <= aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
                count += mid-i+1;
            }
        }
    }
}
