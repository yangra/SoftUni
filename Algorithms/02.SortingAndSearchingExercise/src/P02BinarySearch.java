import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }


        int needle = Integer.parseInt(reader.readLine());
        System.out.println(binarySearch(arr, 0, arr.length - 1, needle));
    }

    private static int binarySearch(int[] arr, int lo, int hi, int needle) {
        if (lo > hi) {
            return -1;
        }

        int middle = (hi + lo) / 2;
        int index;
        if (arr[middle] > needle) {
           index = binarySearch(arr, lo, middle, needle);
        } else if (arr[middle] < needle) {
            index = binarySearch(arr, middle + 1, hi, needle);
        } else {
            index = middle;
        }

        return index;
    }
}
