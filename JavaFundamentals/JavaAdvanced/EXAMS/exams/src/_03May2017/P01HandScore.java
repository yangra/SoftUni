package _03May2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] cards = reader.readLine().split("\\s+");

        int totalSum = 0;
        for (int i = 0; i < cards.length; i++) {
            int sum = 0;
            int counter = 0;
            boolean similar = false;
            while (i + 1 < cards.length && cards[i].charAt(cards[i].length() - 1) == cards[i + 1].charAt(cards[i + 1].length() - 1)) {
                sum += getCardValue(cards[i]);
                i++;
                counter++;
                similar = true;
            }
            if (similar) {
                sum += getCardValue(cards[i]);
                totalSum += sum * (counter + 1);
                similar = false;
            } else {
                totalSum += getCardValue(cards[i]);
            }
        }

        System.out.println(totalSum);
    }

    private static int getCardValue(String card) {
        if (Character.isDigit(card.charAt(0))) {
            if (card.charAt(0) == '1') {
                return 10;
            }

            return Integer.valueOf(card.charAt(0) + "");
        } else {
            switch (card.charAt(0)) {
                case 'J':
                    return 12;
                case 'Q':
                    return 13;
                case 'K':
                    return 14;
                case 'A':
                    return 15;
            }
        }
        return 0;
    }
}
