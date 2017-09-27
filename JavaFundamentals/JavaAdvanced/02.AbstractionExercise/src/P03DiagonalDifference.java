import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        long primDiagonalSum = 0;
        long secDiagonalSum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    primDiagonalSum += matrix[row][col];
                }
                if (row + col == size - 1) {
                    secDiagonalSum += matrix[row][col];
                }
            }
        }

        System.out.println(Math.abs(primDiagonalSum - secDiagonalSum));
    }
}
