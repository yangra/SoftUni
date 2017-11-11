package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02BitShooter {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Long number = Long.parseUnsignedLong(reader.readLine());
        for (int i = 0; i < 3; i++) {
            String[] input = reader.readLine().split(" ");
            int center = Integer.parseInt(input[0]);
            int size = Integer.parseInt(input[1]);
            int damage = size / 2;
            int start = center + damage;
            int end = center - damage;
            if (center + damage > 63) {
                start = 63;
            }
            if (center - damage < 0) {
                end = 0;
            }

            size = start - end + 1;
            long maskNumber = (long) Math.pow(2, size) - 1;
            long mask = ~(maskNumber << start - size + 1);
            number = number & mask;
        }

        int rightCounter = 0;
        for (int i = 0; i < 32; i++) {

            if(((number>>i)&1)==1){
                rightCounter++;
            }
        }
        int leftCounter = 0;
        for (int i = 32; i < 64; i++) {

            if(((number>>i)&1)==1){
                leftCounter++;
            }
        }

        System.out.printf("left: %d\n", leftCounter);
        System.out.printf("right: %d\n", rightCounter);
    }
}
