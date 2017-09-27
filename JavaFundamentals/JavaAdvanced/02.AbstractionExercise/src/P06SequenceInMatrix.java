import java.util.Scanner;

public class P06SequenceInMatrix {

//    private static int bestLength = 0;
//    private static String bestWord = "";
//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        String[] dims = scanner.nextLine().split("\\s+");
//        int rows = Integer.parseInt(dims[0]);
//        int cols = Integer.parseInt(dims[1]);
//
//        String[][] matrix = new String[rows][cols];
//        for (int row = 0; row < matrix.length; row++) {
//            String[] line = scanner.nextLine().split("\\s+");
//            for (int col = 0; col < matrix[0].length; col++) {
//                matrix[row][col] = line[col];
//            }
//        }
//
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[0].length; col++) {
//                int length = 1;
////                length = traverseRow(row, col, matrix, length);
////                checkIfLongestSeq(length, matrix[row][col]);
//
//                length = traversePrimDiag(row, col, matrix, 1);
//                checkIfLongestSeq(length, matrix[row][col]);
//
//                length = traverseCol(row, col, matrix, 1);
//                checkIfLongestSeq(length, matrix[row][col]);
//
////                length = traverseSecDiag(row, col, matrix, 1);
////                checkIfLongestSeq(length, matrix[row][col]);
//            }
//        }
//
//        for (int i = 0; i < bestLength; i++) {
//            System.out.print(bestWord);
//            if (i < bestLength - 1) {
//                System.out.print(", ");
//            }
//        }
//    }
//
//    private static void checkIfLongestSeq(int length, String word) {
//        if (length >= bestLength) {
//            bestLength = length;
//            bestWord = word;
//        }
//    }
//
//    private static int traverseSecDiag(int row, int col, String[][] matrix, int length) {
//        if ((row + 1) < matrix.length &&
//                (col - 1) >= 0 && (col - 1) < matrix[0].length &&
//                matrix[row][col].equals(matrix[row + 1][col - 1])) {
//            length = traverseSecDiag(row + 1, col - 1, matrix, length + 1);
//        }
//        return length;
//    }
//
//    private static int traversePrimDiag(int row, int col, String[][] matrix, int length) {
//        if ((row + 1) < matrix.length && (col + 1) < matrix[0].length &&
//                matrix[row][col].equals(matrix[row + 1][col + 1])) {
//            length = traversePrimDiag(row + 1, col + 1, matrix, length + 1);
//        }
//        return length;
//    }
//
//    private static int traverseCol(int row, int col, String[][] matrix, int length) {
//        if ((row + 1) < matrix.length && matrix[row][col].equals(matrix[row + 1][col])) {
//            length = traverseCol(row + 1, col, matrix, length + 1);
//        }
//        return length;
//    }
//
//    private static int traverseRow(int row, int col, String[][] matrix, int length) {
//        if ((col + 1) < matrix[0].length && matrix[row][col].equals(matrix[row][col + 1])) {
//            length = traverseRow(row, col + 1, matrix, length + 1);
//        }
//        return length;
//    }

    private static int bestLength = 0;
    private static String bestWord = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dims = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dims[0]);
        int cols = Integer.parseInt(dims[1]);

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            matrix[row] = line;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                tryDiagonal(matrix, row, col);
                tryRow(matrix, row, col);
                tryColumn(matrix, row, col);
            }
        }

        for (int i = 0; i < bestLength; i++) {
            System.out.print(bestWord);
            if (i < bestLength - 1) {
                System.out.print(", ");
            }
        }
    }

    private static void tryColumn(String[][] matrix, int row, int col) {
        int length = 1;
        int currentRow = row;
        while (currentRow + 1 < matrix.length) {
            if (matrix[currentRow][col].equals(matrix[currentRow + 1][col])) {
                length++;
            } else {
                break;
            }
            currentRow++;
        }

        checkIfLongestSeq(length, matrix[row][col]);
    }

    private static void tryRow(String[][] matrix, int row, int col) {
        int length = 1;
        int currentCol = col;
        while (currentCol + 1 < matrix[0].length) {
            if (matrix[row][currentCol].equals(matrix[row][currentCol + 1])) {
                length++;
            } else {
                break;
            }
            currentCol++;
        }

        checkIfLongestSeq(length, matrix[row][col]);
    }


    private static void tryDiagonal(String[][] matrix, int row, int col) {
        int length = 1;
        int currentRow = row;
        int currentCol = col;
        while (currentRow + 1 < matrix.length && currentCol + 1 < matrix[0].length) {
            if (matrix[currentRow][currentCol].equals(matrix[currentRow + 1][currentCol + 1])) {
                length++;
            } else {
                break;
            }
            currentRow++;
            currentCol++;
        }

        checkIfLongestSeq(length, matrix[row][col]);
    }

    private static void checkIfLongestSeq(int length, String str) {
        if (length >= bestLength) {
            bestLength = length;
            bestWord = str;
        }
    }


}