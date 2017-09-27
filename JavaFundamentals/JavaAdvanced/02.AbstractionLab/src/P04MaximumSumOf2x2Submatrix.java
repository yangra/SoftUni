import java.util.Scanner;

public class P04MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split(", ");
            for (int col = 0; col < matrix[0].length; col++) {
               matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        int bestSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int row = 0; row < matrix.length-1; row++) {
            for (int col = 0; col < matrix[0].length-1; col++) {
               int sum = matrix[row][col] + matrix[row][col+1]
                        + matrix[row+1][col] + matrix[row+1][col+1];

               if(sum > bestSum){
                    bestSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.println(matrix[startRow][startCol] + " " + matrix[startRow][startCol+1]);
        System.out.println(matrix[startRow+1][startCol] + " " + matrix[startRow+1][startCol+1]);
        System.out.println(bestSum);
    }
}
