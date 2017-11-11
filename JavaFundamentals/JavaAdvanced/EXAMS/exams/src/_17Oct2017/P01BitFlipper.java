package _17Oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01BitFlipper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Long number = Long.parseUnsignedLong(reader.readLine());
        for (int i = 61; i >= 0 ; i--) {
            if(((number>>i)&7)==7||((number>>i)&7)==0){
                number ^= (7L<<i);
                i-=2;
            }
        }

        System.out.println(Long.toUnsignedString(number));
    }
}
