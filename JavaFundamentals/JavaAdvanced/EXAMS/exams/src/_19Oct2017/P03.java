package _19Oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer num = Integer.parseInt(reader.readLine());
        Integer freeze = Integer.parseInt(reader.readLine());
        Integer rolls = Integer.parseInt(reader.readLine());

        int firstBit = 0;
        int frozenBit = num >> freeze & 1;
        int jumpBit = 0;
        for (int i = 0; i < rolls % 18; i++) {
            if (freeze == 0) {
                firstBit = num >> 1 & 1;
            } else {
                firstBit = num & 1;
            }

            num >>= 1;

            if (firstBit == 1) {
                num = (1 << 18) | num;
            }

            jumpBit = num >> freeze & 1;
            if (freeze != 0) {
                num = setBitValue(num, jumpBit, freeze - 1);
            } else {
                num = setBitValue(num, jumpBit, 18);
            }
            num = setBitValue(num, frozenBit, freeze);


        }

        System.out.println(num);

    }

    private static Integer setBitValue(Integer num, int bit, int position) {
        if (bit == 0) {
            num = ~(1 << position) & num;
        } else {
            num = (1 << position) | num;
        }
        return num;
    }
}


