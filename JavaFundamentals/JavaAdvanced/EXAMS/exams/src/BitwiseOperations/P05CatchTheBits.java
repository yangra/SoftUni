package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05CatchTheBits {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int step = Integer.parseInt(reader.readLine());
        int index = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());
            for (int bitPosition = 7; bitPosition >= 0; bitPosition--) {
                if (index % step == 1||(step==1&&index>0)) {
                    int mask = 1 << bitPosition;
                    if ((num & mask) != 0) {
                        result.append("1");
                    } else {
                        result.append("0");
                    }
                }
                index++;
                if (result.length() == 8) {
                    System.out.println(Integer.parseInt(result.toString(),2));
                    result = new StringBuilder();
                }
            }
        }
        if (result.length() > 0) {
            while (result.length() % 8 != 0) {
                result.append("0");
            }
            System.out.println(Integer.parseInt(result.toString(),2));
        }
    }
}
