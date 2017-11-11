package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P09BitwiseOperators {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            Integer num = Integer.parseInt(reader.readLine());
            Integer reversed = 0;
            //String reverseStr = Integer.toBinaryString(num);
            Integer bitsCounter = 0;
            long value = 1;
            while (num >= value) {
                value *= 2;
                bitsCounter++;
            }
            for (int pos = 0; pos < bitsCounter; pos++) {
                reversed = reversed << 1;
                reversed = reversed | ((num >> pos) & 1);
            }
            //System.out.println(Integer.toBinaryString(reversed));
            System.out.println(reversed);
        }
    }
}
