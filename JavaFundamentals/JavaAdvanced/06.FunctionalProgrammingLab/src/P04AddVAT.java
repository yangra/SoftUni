import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class P04AddVAT {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] result = Arrays.stream(reader.readLine().split(",\\s+")).mapToDouble(Double::parseDouble).toArray();

        UnaryOperator<Double> addVAT = x->x*1.2;

        System.out.println("Prices with VAT:");
        for (double number : result) {
            System.out.println(String.format("%.2f",addVAT.apply(number)).replace(".",","));
        }
    }
}
