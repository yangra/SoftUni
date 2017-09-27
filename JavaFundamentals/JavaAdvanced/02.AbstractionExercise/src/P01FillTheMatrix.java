import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String type = input[1];

        int[][] matrix = new int[size][size];
        if (type.equals("A")) {
            fillMatrixA(matrix);
        } else {
            fillMatrixB(matrix);
        }

        print(matrix);
    }

    private static void fillMatrixA(int[][] matrix) {
        int counter = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[col][row] = counter;
                counter++;
            }
        }
    }

    private static void fillMatrixB(int[][] matrix) {
        int counter = 1;
        for (int row = 0; row < matrix.length; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < matrix[0].length; col++) {
                    matrix[col][row] = counter;
                    counter++;
                }
            } else {
                for (int col = matrix[0].length-1; col >= 0; col--) {
                    matrix[col][row] = counter;
                    counter++;
                }
            }
        }
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem :row) {
                System.out.print(elem + " ");
            }

            System.out.println();
        }
    }
}
