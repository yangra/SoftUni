package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14SaltAndPepper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Long number = Long.parseUnsignedLong(reader.readLine());

        while (true) {
            String[] command = reader.readLine().split(" ");
            if ("end".equals(command[0])) {
                break;
            }

            int step = Integer.parseInt(command[1]);
            if ("pepper".equals(command[0])) {
                for (int i = 0; i < 64; i+=step) {
                    number |=  1L << i;

                }
            }else{
                for (int i = 0; i < 64; i+=step) {
                    number &=  ~(1L << i);
                }
            }
        }

        System.out.println(Long.toUnsignedString(number));
    }
}
