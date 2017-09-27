import java.util.Scanner;

public class P07CollectTheCoins {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[4][];
        for (int i = 0; i < 4; i++) {
            String row = scanner.nextLine();
            char[] charRow = row.toCharArray();
            board[i] = charRow;
        }

        String moves = scanner.nextLine();
        int row = 0;
        int col = 0;

        int coins = 0;
        int wallHits = 0;

        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case '>':
                    if (col + 1 < board[row].length) {
                        col++;
                        if (board[row][col] == '$') {
                            coins++;
                        }
                    } else {
                        wallHits++;
                    }
                    break;
                case '<':
                    if (col - 1 >= 0) {
                        col--;
                        if (board[row][col] == '$') {
                            coins++;
                        }
                    } else {
                        wallHits++;
                    }
                    break;
                case '^':
                    if (row - 1 >= 0 && col < board[row - 1].length) {
                        row--;
                        if (board[row][col] == '$') {
                            coins++;
                        }
                    } else {
                        wallHits++;
                    }
                    break;
                case 'V':
                    if (row + 1 < board.length && col < board[row+1].length) {
                        row++;
                        if (board[row][col] == '$') {
                            coins++;
                        }
                    } else {
                        wallHits++;
                    }
                    break;
            }
        }

        System.out.printf("Coins = %d\n", coins);
        System.out.printf("Walls = %d\n", wallHits);
    }
}
