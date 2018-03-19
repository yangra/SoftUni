import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03RecursiveDrawing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        draw(num);
    }

    private static void draw(int num) {
        if (num == 0) {
            return;
        }
        System.out.println(new String(new char[num]).replace("\0", "*"));
        draw(num - 1);
        System.out.println(new String(new char[num]).replace("\0", "#"));
    }
}
