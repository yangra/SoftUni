import java.util.Scanner;

public class P05MaximalSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        if (rows > 3 && cols > 3) {
            long[] result = findMaxSum(matrix);
            System.out.printf("Sum = %d\n", result[2]);
            printSubMatrix((int) result[0], (int) result[1], matrix);
        }
    }

    private static void printSubMatrix(int startRow, int startCol, int[][] matrix) {
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static long[] findMaxSum(int[][] matrix) {
        long[] result = new long[3];
        result[2] = Long.MIN_VALUE;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {
                long sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (sum > result[2]) {
                    result[2] = sum;
                    result[0] = row;
                    result[1] = col;
                }
            }
        }

        return result;
    }
}
