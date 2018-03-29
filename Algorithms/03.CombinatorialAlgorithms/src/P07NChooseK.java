import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P07NChooseK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        long result = factorial(n,n-k+1)/ factorial(k, 1);
        System.out.println(result);
    }

    private static long factorial(int n, int border) {
        if(n == border){
            return border;
        }

        return n * factorial(n-1,border);
    }
}
