import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P05EgyptianFractions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("/");
        int numerator = Integer.parseInt(input[0]);
        int denominator = Integer.parseInt(input[1]);
        if (numerator > denominator) {
            System.out.println("Error (fraction is equal to or greater than 1)\n");
            return;
        }

        StringBuilder result = new StringBuilder();
        result.append(String.format("%d/%d = ", numerator, denominator));
        int fracDenominator = 2;
        while (numerator > 0) {

            if (denominator % fracDenominator == 0) {
                if (denominator / fracDenominator <= numerator) {
                    numerator -= denominator / fracDenominator;
                    print(numerator, result, fracDenominator);
                }
            } else {
                if(numerator*fracDenominator>= denominator) {
                    numerator *= fracDenominator;
                    numerator -= denominator;
                    denominator *= fracDenominator;
                    print(numerator, result, fracDenominator);
                }
            }
            fracDenominator++;
        }

        System.out.println(result.toString());
    }

    private static void print(int numerator, StringBuilder result, int fracDenominator) {
        result.append(String.format("1/%d",fracDenominator));
        if(numerator!=0){
            result.append(" + ");
        }
    }
}
