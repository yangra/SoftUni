import java.util.Arrays;
import java.util.Scanner;

public class P13BlurFilter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int blurFactor = Integer.parseInt(scanner.nextLine());
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        long[][] matrix = new long[size[0]][size[1]];

        for (int i = 0; i < size[0]; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < size[1]; j++) {
                matrix[i][j] = row[j];
            }
        }

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int row = coordinates[0] - 1; row <= coordinates[0] + 1; row++) {
            for (int col = coordinates[1] - 1; col <= coordinates[1] + 1; col++) {
                if (row >= 0 && row < size[0] && col >= 0 && col < size[1]) {
                    matrix[row][col] += blurFactor;
                }
            }
        }

        for (int row = 0; row < size[0]; row++) {
            for (int col = 0; col < size[1]; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
