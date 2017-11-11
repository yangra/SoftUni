package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10FriendBits {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer number = Integer.parseUnsignedInt(reader.readLine());
        Integer a = 0;
        Integer f = 0;
        for (int i = 31; i > 0; i--) {
            int counter = 1;
            while (i - 1 >= 0 && (((number >> i) & 1) == ((number >> i - 1) & 1))) {
                counter++;
                i--;
            }
            if (counter > 1) {
                for (int j = 0; j < counter; j++) {
                    f = f << 1;
                    f = f | ((number >> i) & 1);

                }
            }
            if (counter == 1) {
                a = a << 1;
                a = a | ((number >> i) & 1);

            }

            if (i == 1) {
                a = a << 1;
                a = a | ((number >> i - 1) & 1);
            }
        }

        System.out.println(Integer.toUnsignedString(f));
        System.out.println(Integer.toUnsignedString(a));
    }
}
