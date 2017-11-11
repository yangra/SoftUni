package _03May2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P03ChessKnight {
    private static final int BOARD_SIZE = 8;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[][] board = new String[BOARD_SIZE][BOARD_SIZE];
        for (int row = 0; row < BOARD_SIZE; row++) {
            String[] line = reader.readLine().split("\\|");
            for (int col = 0; col < line.length; col++) {
                board[row][col] = line[col];
            }
        }

        String initialPosition = reader.readLine();
        int x = Integer.valueOf(initialPosition.charAt(0) + "");
        int y = Integer.valueOf(initialPosition.charAt(1) + "");

        List<String> takenPieces = new ArrayList<>();
        int invalidMoves = 0;
        int outOfBoardMoves = 0;
        while (true) {
            String[] move = reader.readLine().split(" -> ");
            if ("END".equalsIgnoreCase(move[0])) {
                break;
            }

            x = Integer.valueOf(move[0].charAt(0) + "");
            y = Integer.valueOf(move[0].charAt(1) + "");

            int nextX = Integer.valueOf(move[1].charAt(0) + "");
            int nextY = Integer.valueOf(move[1].charAt(1) + "");

            if (x + 1 == nextX && y + 2 == nextY || x + 1 == nextX && y - 2 == nextY ||
                    x - 1 == nextX && y + 2 == nextY || x - 1 == nextX && y - 2 == nextY ||
                    x + 2 == nextX && y - 1 == nextY || x - 2 == nextX && y - 1 == nextY ||
                    x - 2 == nextX && y + 1 == nextY || x + 2 == nextX && y + 1 == nextY) {

                if (nextX < 0 || nextX >= BOARD_SIZE || nextY < 0 || nextY >= BOARD_SIZE) {
                    outOfBoardMoves++;
                    continue;
                }

                x = nextX;
                y = nextY;
                if(!board[x][y].equals(" ")){
                    takenPieces.add(board[x][y]);
                }

            }else {
                invalidMoves++;
            }
        }

        System.out.printf("Pieces take: %s\n",takenPieces.toString().replaceAll("[\\[\\]]", ""));
        System.out.printf("Invalid moves: %d\n",invalidMoves);
        System.out.printf("Board out moves: %d\n", outOfBoardMoves);
    }
}