package _03September2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01DozenEggs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer dozens = 0;
        Integer eggs = 0;
        for (int i = 0; i < 7; i++) {
            String[] input = reader.readLine().split(" ");
            Integer quantity = Integer.parseInt(input[0]);
            switch (input[1]) {
                case "eggs":
                    eggs += quantity;
                    break;
                case "dozens":
                    dozens += quantity;
                    break;
            }
        }

        dozens += eggs / 12;
        eggs %= 12;

        System.out.printf("%d dozens + %d eggs", dozens, eggs);
    }
}
