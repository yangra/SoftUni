import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P05Needles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = readArr(reader,2);
        int[] arr = readArr(reader, nums[0]);
        int[] toAdd = readArr(reader, nums[1]);

        for (int i = 0; i < nums[1]; i++) {
            System.out.print(binarySearch(toAdd[i], arr, 0, nums[0] - 1) + " ");
        }
    }

    private static int[] readArr(BufferedReader reader, int num) throws IOException {
        String[] input = reader.readLine().split(" ");
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }

    private static int binarySearch(int num, int[] arr, int lo, int hi) {
        if (lo == hi) {
            return lo;
        }
        if (lo > hi) {
            return hi + 1;
        }

        int mid = (lo + hi) / 2;
        while (arr[mid] == 0 && mid > lo) {
            mid--;
        }
        if (mid == lo && arr[mid] == 0) {
            mid = (lo + hi) / 2;
            while (arr[mid] == 0 && mid < hi) {
                mid++;
            }
            if (mid == hi && (arr[mid] == 0 || arr[mid] > num)) {
                return lo;
            }
        }
        int index;
        if (arr[mid] > num) {
            index = binarySearch(num, arr, lo, mid);
        } else if (arr[mid] < num) {
            index = binarySearch(num, arr, mid + 1, hi);
        } else {
            while (num == arr[mid] || arr[mid] == 0) {
                mid--;
                if (mid == -1) {
                    return 0;
                }
            }
            return mid + 1;
        }

        return index;
    }
}
