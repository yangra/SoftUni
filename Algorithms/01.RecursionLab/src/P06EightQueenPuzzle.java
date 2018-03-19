public class P06EightQueenPuzzle {
    public static void main(String[] args) {
        int[][] board = new int[8][8];
        generate(0, board);
    }

    private static void generate(int row, int[][] board) {
        if (row == 8) {
            print(board);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSave(row, i, board)) {
                board[row][i] = 1;
                generate(row + 1, board);
                board[row][i] = 0;
            }
        }

    }

    private static boolean isSave(int row, int col, int[][] board) {
        if (checkLeftDiagonal(row, col, board) &&
                checkRightDiagonal(row, col, board) &&
                checkVertical(row, col, board)) {
            return true;
        }
        return false;
    }

    private static boolean checkVertical(int row, int col, int[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRightDiagonal(int row, int col, int[][] board) {
        while (row >= 0 && col >= 0) {
            if (board[row--][col--] == 1) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkLeftDiagonal(int row, int col, int[][] board) {
        while (row >= 0 && col < board.length) {
            if (board[row--][col++] == 1) {
                return false;
            }
        }

        return true;
    }


    private static void print(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                int[] ints = board[col];
                System.out.print(board[row][col] == 1 ? "* " : "- ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
