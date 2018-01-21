import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _07DistanceInLabyrinth {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        String[][] board = new String[size][size];
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < size; i++) {
            String row = reader.readLine();
            for (int j = 0; j < size; j++) {
                board[i][j] = row.substring(j, j + 1);
                if (board[i][j].equals("*")) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(startRow, startCol, 1));
        while (queue.size() > 0) {
            Node start = queue.poll();
            startRow = start.row;
            startCol = start.col;

            if (startRow + 1 >= 0 && startRow + 1 < size && startCol >= 0 && startCol < size &&
                    board[startRow + 1][startCol].equals("0")) {
                board[startRow + 1][startCol] = Integer.toString(start.dist);
                queue.offer(new Node(startRow + 1, startCol, start.dist + 1));
            }
            if (startRow >= 0 && startRow < size && startCol + 1 >= 0 && startCol + 1 < size &&
                    board[startRow][startCol + 1].equals("0")) {
                board[startRow][startCol + 1] = Integer.toString(start.dist);
                queue.offer(new Node(startRow, startCol + 1, start.dist + 1));
            }
            if (startRow - 1 >= 0 && startRow - 1 < size && startCol >= 0 && startCol < size &&
                    board[startRow - 1][startCol].equals("0")) {
                board[startRow - 1][startCol] = Integer.toString(start.dist);
                queue.offer(new Node(startRow - 1, startCol, start.dist + 1));
            }
            if (startRow >= 0 && startRow < size && startCol - 1 >= 0 && startCol - 1 < size &&
                    board[startRow][startCol - 1].equals("0")) {
                board[startRow][startCol - 1] = Integer.toString(start.dist);
                queue.offer(new Node(startRow, startCol - 1, start.dist + 1));
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col].equals("0")) {
                    board[row][col] = "u";
                }
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

    private static class Node {
        private int row;
        private int col;
        private int dist;

        public Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
