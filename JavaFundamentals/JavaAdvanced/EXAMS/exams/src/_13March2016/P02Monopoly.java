package _13March2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class P02Monopoly {

    private static int money = 50;
    private static int numberOfHotels = 0;
    private static int moveCounter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] size = Arrays.stream(reader.readLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);

        for (int i = 0; i < size[0]; i++) {
            String row = reader.readLine();
            if (i % 2 == 0) {
                for (int j = 0; j < row.length(); j++) {
                    makeMove(row.charAt(j), i, j);
                }
            } else {
                for (int j = row.length()-1; j >= 0; j--) {
                    makeMove(row.charAt(j), i, j);
                }
            }
        }

        System.out.printf("Turns %d\n", moveCounter);
        System.out.printf("Money %d\n", money);

    }

    private static void makeMove(char current,  int row, int col) {
        switch (current) {
            case 'F':
                moveCounter++;
                money += 10 * numberOfHotels;
                break;
            case 'H':
                numberOfHotels++;
                System.out.printf("Bought a hotel for %d. Total hotels: %d.\n", money, numberOfHotels);
                money = 0;
                moveCounter++;
                money += 10 * numberOfHotels;
                break;
            case 'J':
                System.out.printf("Gone to jail at turn %d.\n",moveCounter);
                moveCounter+=3;
                money += 30 * numberOfHotels;
                break;
            case 'S':
                System.out.printf("Spent %d money at the shop.\n",Math.min(((row+1) * (col+1)), money));
                money -= Math.min(((row+1) * (col+1)), money);
                moveCounter++;
                money += 10 * numberOfHotels;
                break;
        }
    }
}
