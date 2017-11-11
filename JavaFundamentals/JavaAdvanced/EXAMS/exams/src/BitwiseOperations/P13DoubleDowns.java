package BitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P13DoubleDowns {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        long[] board = new long[n];
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(reader.readLine());
        }

        int rightDiaCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 31; j++) {
                if (i - 1 >= 0 && (board[i] & (1 << j)) != 0 && (board[i - 1] & (1 << j + 1)) != 0) {
                    rightDiaCount++;
                }
            }
        }

        int leftDiaCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 32; j++) {
                if (i - 1 >= 0 && j - 1 >= 0 && (board[i] & (1 << j)) != 0 && (board[i - 1] & (1 << j - 1)) != 0) {
                    leftDiaCount++;
                }
            }
        }

        int verticalCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 32; j++) {
                if (i - 1 >= 0 && (board[i] & (1 << j)) != 0 && (board[i - 1] & (1 << j)) != 0) {
                    verticalCount++;
                }
            }
        }

        System.out.println(rightDiaCount);
        System.out.println(leftDiaCount);
        System.out.println(verticalCount);
    }
}
