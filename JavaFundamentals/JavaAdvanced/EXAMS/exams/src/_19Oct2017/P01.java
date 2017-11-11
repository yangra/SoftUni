package _19Oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class P01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        ArrayDeque<String> cards = new ArrayDeque<>();

        Long result = 0L;
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            cards.offer(input[i]);
        }

        int counter = 1;
        while (cards.size() > 0) {
            String card = cards.poll();
            Character suit = card.charAt(card.length() - 1);
            int power = getPower(card.charAt(0));

            if (cards.size() > 0 && suit == cards.peek().charAt(cards.peek().length() - 1)) {
                sum += power;
                counter++;
                continue;
            }

            if (counter > 1 && sum > 0) {
                sum += power;
                result += sum * counter;
                counter = 1;
                sum = 0;
                continue;
            } else {
                sum += power;
            }

            result += sum;
            sum = 0;
        }
        System.out.println(result);
    }


    private static int getPower(char c) {
        switch (c) {
            case '1':
                return 10;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
                return 15;
            case 'K':
                return 14;
            case 'Q':
                return 13;
            default:
                return 12;
        }
    }
}