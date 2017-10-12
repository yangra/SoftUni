import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class P02SumNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<String,Integer> parse = x->Integer.parseInt(x);
        String[] input = reader.readLine().split("\\s*,\\s+");
        int sum = 0;
        for (String s : input) {
            sum += parse.apply(s);
        }

        System.out.printf("Count = %d\n",input.length );
        System.out.printf("Sum = %d",sum);
    }
}
