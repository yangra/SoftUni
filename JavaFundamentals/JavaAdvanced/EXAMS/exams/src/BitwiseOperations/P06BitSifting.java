package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P06BitSifting {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Long bitsToSift = Long.parseUnsignedLong(reader.readLine());
        int numberOfSieves = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfSieves; i++) {
            Long sieve = Long.parseUnsignedLong(reader.readLine());

            bitsToSift = (bitsToSift^sieve)&bitsToSift;
        }

        int counter = 0;
        for (int i = 0; i <64 ; i++) {
           if( ((bitsToSift>>i)&1)==1){
               counter++;
           }
        }

        System.out.println(counter);

    }
}
