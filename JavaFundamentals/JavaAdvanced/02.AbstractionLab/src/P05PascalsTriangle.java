import java.math.BigDecimal;
import java.util.Scanner;

public class P05PascalsTriangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        BigDecimal[][] result = new BigDecimal[n][n];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length ; j++) {
                result[i][j] = BigDecimal.ZERO;
            }
        }
        for (int row = 0; row < n; row++) {
            result[row][0] = BigDecimal.ONE;
            System.out.print(result[row][0] + " ");

            if (row > 0) {
                for (int col = 1; col < row + 1; col++) {
                    BigDecimal[] previousRow = result[row - 1];
                    result[row][col] = previousRow[col - 1].add(previousRow[col]);
                    System.out.print(result[row][col] + " ");
                }
            }

            System.out.println();
        }


    }
}
