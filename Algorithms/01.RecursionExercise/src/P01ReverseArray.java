import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] array = reader.readLine().split(" ");

        reverse(0,array);
    }

    private static void reverse(int index, String[] array) {
        if(index == array.length){
            return;
        }

        reverse(index+1, array);
        System.out.print(array[index]+" ");
    }
}
