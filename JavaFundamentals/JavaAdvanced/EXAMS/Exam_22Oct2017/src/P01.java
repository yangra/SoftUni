import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");
        short[] numbers = new short[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Short.parseShort(input[i]);
        }


        for (int j = 0; j < numbers.length; j++) {
            for (int i = 0; i < numbers.length - 1; i++) {
                if(numbers[i] == 0){
                    continue;
                }
                short temp = numbers[i];
                short tempNext = numbers[i + 1];

                numbers[i + 1] = (short)(temp|tempNext);
                numbers[i] = (short)(temp & tempNext);

            }
        }

        StringBuilder b = new StringBuilder();
        for (int i = 0; i<numbers.length; i++) {
            b.append(numbers[i]);
            if (i != numbers.length - 1)
                b.append(", ");
        }

        System.out.println(b.toString());
    }
}
