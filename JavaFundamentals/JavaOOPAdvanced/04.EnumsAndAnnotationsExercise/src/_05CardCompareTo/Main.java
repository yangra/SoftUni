package _05CardCompareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rankOne = reader.readLine();
        String suitOne = reader.readLine();
        String rankTwo = reader.readLine();
        String suitTwo = reader.readLine();
        Card cardOne = new Card(rankOne, suitOne);
        Card cardTwo = new Card(rankTwo, suitTwo);
        System.out.println(cardOne.compareTo(cardTwo) > 0 ? cardOne : cardTwo);
    }
}
