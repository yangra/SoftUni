import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01ReverseArray {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split(" ");
        reverse(array, 0);
    }

    private static void reverse(String[] array, int index) {
        if (index == array.length) {
            return;
        }

        reverse(array, index + 1);
        System.out.print(array[index] + " ");
    }
}
