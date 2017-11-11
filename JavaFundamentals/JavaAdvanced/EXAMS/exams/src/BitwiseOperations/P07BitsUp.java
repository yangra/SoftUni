package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P07BitsUp {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfBytes = Integer.parseInt(reader.readLine());
        int step = Integer.parseInt(reader.readLine());
        int index = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numberOfBytes; i++) {
            int num = Integer.parseInt(reader.readLine());
            for (int pos = 7; pos >= 0; pos--) {

                if (index % step == 1 || (step == 1 & index > 0)) {
                    num = num | (1 << pos);
                }

                if (((num >> pos) & 1) == 1) {
                    result.append("1");
                } else {
                    result.append("0");
                }

                if (result.length() % 8 == 0) {
                    System.out.println(Integer.parseInt(result.toString(), 2));
                    result = new StringBuilder();
                }
                index++;
            }
        }
    }
}
