package _08CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstPlayerName = reader.readLine();
        String secondPlayerName = reader.readLine();
        List<Card> firstPlayer = new ArrayList<>();
        List<Card> secondPlayer = new ArrayList<>();
        List<Card> cards = new ArrayList<>();
        while(firstPlayer.size()<5||secondPlayer.size()<5){
            try {
                String[] input = reader.readLine().split("\\s+of\\s+");
                Card card = new Card(input[0], input[1]);
                for (Card c : cards) {
                    if(c.compareTo(card)==0){
                        throw new IllegalArgumentException("Card is not in the deck.");
                    }
                }
                if(firstPlayer.size()<5){
                    firstPlayer.add(card);

                }else{
                    secondPlayer.add(card);
                }
                cards.add(card);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

        Card winningFirst = findStrongestCardInHand(firstPlayer);
        Card winningSecond = findStrongestCardInHand(secondPlayer);

        if(winningFirst.compareTo(winningSecond)>0){
            System.out.printf("%s wins with %s.\n", firstPlayerName, winningFirst);
        }else{
            System.out.printf("%s wins with %s.\n", secondPlayerName, winningSecond);
        }
    }

    private static Card findStrongestCardInHand(List<Card> hand) {
        Card strongest = hand.get(0);
        for (Card card : hand) {
            if(strongest.compareTo(card)<0){
                strongest = card;
            }
        }
        return strongest;
    }
}
