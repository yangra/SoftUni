import java.util.Scanner;

public class P04SquaresInMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col];
            }
        }

        int count = countSquares(matrix);
        System.out.println(count);
    }

    private static int countSquares(String[][] matrix) {
        int counter = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                if (matrix[row][col].equals(matrix[row][col + 1]) &&
                        matrix[row][col].equals(matrix[row + 1][col]) &&
                        matrix[row][col].equals(matrix[row + 1][col + 1])) {
                    counter++;
                }
            }
        }

        return counter;
    }
}
