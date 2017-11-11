package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03BitRoller {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        System.out.println(Integer.toBinaryString(number));
        int frozenPosition = Integer.parseInt(reader.readLine());
        int rolls = Integer.parseInt(reader.readLine());

        for (int i = 0; i < rolls % 18; i++) {
            int rolledBit = number & 1;
            if (frozenPosition == 0) {
                rolledBit = (number & (1 << 1)) == 0 ? 0 : 1;
            }
            int frozenBit = (number & (1 << frozenPosition)) == 0 ? 0 : 1;

            number = number >> 1;
            int jumpBit = (number & (1 << frozenPosition)) == 0 ? 0 : 1;

            if (frozenBit == 1) {
                number = number | (1 << frozenPosition);
            } else {
                number = number & (~(1 << frozenPosition));
            }
            if (frozenPosition == 18) {
                if (rolledBit == 1) {
                    number = number | (1 << 17);
                } else {
                    number = number & (~(1 << 17));
                }
                continue;

            } else {
                if (rolledBit == 1) {
                    number = number | (1 << 18);
                } else {
                    number = number & (~(1 << 18));
                }
            }
            if (frozenPosition != 0) {
                if (jumpBit == 1) {
                    number = number | (1 << frozenPosition - 1);
                } else {
                    number = number & (~(1 << frozenPosition - 1));
                }
            }
        }

        System.out.println(Integer.toBinaryString(number));
        System.out.println(number);
    }
}
