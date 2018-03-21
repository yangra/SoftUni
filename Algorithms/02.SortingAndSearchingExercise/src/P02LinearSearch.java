import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02LinearSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int needle = Integer.parseInt(reader.readLine());
        System.out.println(linearSearch(arr, needle));
    }

    private static int linearSearch(int[] arr, int needle) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == needle) {
                return i;
            }
        }
        return -1;
    }
}
