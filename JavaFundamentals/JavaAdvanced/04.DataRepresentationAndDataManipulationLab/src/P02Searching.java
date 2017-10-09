import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02Searching {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int number = Integer.parseInt(reader.readLine());

        int result = linearSearch(array, number);

        System.out.println(result);

    }

    private static int binarySearch(int[] array, int number) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        int middle;
        while (firstIndex <= lastIndex) {
            middle = (firstIndex + lastIndex) / 2;
            if (number < array[middle]) {
                lastIndex = middle - 1;
            } else if (number > array[middle]) {
                firstIndex = middle+1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    private static int linearSearch(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }

        return -1;
    }
}
