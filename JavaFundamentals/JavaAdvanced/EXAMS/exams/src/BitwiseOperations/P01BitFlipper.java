package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01BitFlipper {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Long number = Long.parseUnsignedLong(reader.readLine());
        for (int i = 61; i >= 0; i--) {

            Long searchMask = 7L << i;

            if ((number & searchMask) == 0L||(number & searchMask) == searchMask) {
                number = number ^ searchMask;
                i-=2;
            }
        }

        String result =  Long.toUnsignedString(number);
        System.out.println(result);
    }


}
