package _08May2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03RoyalFlush {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        StringBuilder cards = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String combination = reader.readLine();
            cards.append(combination);
        }

        String[] flush = new String[]{"10", "J", "Q", "K", "A"};

        Pattern card = Pattern.compile("[A-Z1-9]0?[a-z]");
        Matcher matcher = card.matcher(cards);
        Map<String, Integer> flushes = new HashMap<>();
        int counter = 0;
        while (matcher.find()) {
            String match = matcher.group();
            String rank = match.substring(0, match.length() - 1);
            String suit = match.substring(match.length() - 1);
            if (rank.equals("10")) {
                flushes.put(suit, 0);
                continue;
            }

            if (flushes.containsKey(suit) && flushes.get(suit) + 1 < flush.length &&
                    rank.equals(flush[flushes.get(suit) + 1])) {
                if(flushes.get(suit) + 1==4){
                    System.out.printf("Royal Flush Found - %s\n",getSuit(suit));
                    counter++;
                    flushes.remove(suit);
                }else {
                    flushes.put(suit, flushes.get(suit) + 1);
                }
            }else {
                flushes.remove(suit);
            }
        }

        System.out.printf("Royal's Royal Flushes - %d.\n", counter);
    }

    private static String getSuit(String suit){
        switch(suit){
            case "c":
                return "Clubs";
            case "d":
                return "Diamonds";
            case "s":
                return "Spades";
            default:
               return  "Hearts";
        }
    }
}
