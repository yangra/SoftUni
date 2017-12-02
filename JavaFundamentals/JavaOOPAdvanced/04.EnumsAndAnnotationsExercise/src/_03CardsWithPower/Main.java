package _03CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rank = reader.readLine();
        String suit = reader.readLine();
        System.out.printf("Card name: %s of %s; Card power: %d\n", rank.toUpperCase(), suit.toUpperCase(),
                Enum.valueOf(CardRank.class, rank.toUpperCase()).getPower() +
                        Enum.valueOf(CardSuit.class, suit.toUpperCase()).getPower());
    }
}
