package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12ChangeEvenBits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        Long number = Long.parseUnsignedLong(reader.readLine());

        int changedBits = 0;
        for (int num : numbers) {
            int bitCounter = 0;
            if(num == 0){
                bitCounter++;
            }
            while (num > 0) {
                bitCounter++;
                num = num >> 1;
            }

            for (int i = 0; i < bitCounter; i++) {
                if ((number & (1 << i * 2)) == 0) {
                    number = number | (1 << (i * 2));
                    changedBits++;
                }
            }

        }

        System.out.println(Long.toUnsignedString(number));
        System.out.println(changedBits);
    }
}
