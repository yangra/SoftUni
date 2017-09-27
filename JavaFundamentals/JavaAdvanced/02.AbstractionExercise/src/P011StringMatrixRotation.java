import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P011StringMatrixRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String rotate = scanner.nextLine().replace("Rotate(", "").replace(")", "");
        int degrees = Integer.parseInt(rotate);
        int expectedResult = (degrees % 360) / 90;

        List<String> lines = new ArrayList<>();
        int maxLength = 0;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }

            if (line.length() > maxLength) {
                maxLength = line.length();
            }

            lines.add(line);
        }

        char[][] matrix = new char[lines.size()][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = lines.get(row).toCharArray();
        }

        switch (expectedResult) {
            case 0:
                printMatrix(matrix);
                break;
            case 1:
                char[][] rotated90 = new char[maxLength][lines.size()];
                for (int row = 0; row < rotated90.length; row++) {
                    int iter = matrix.length - 1;
                    for (int col = 0; col < rotated90[0].length; col++) {
                        if (row < matrix[iter].length) {
                            rotated90[row][col] = matrix[iter][row];
                        }else{
                            rotated90[row][col] = ' ';
                        }
                        iter--;
                    }
                }

                printMatrix(rotated90);
                break;
            case 2:
                char[][] rotated180 = new char[lines.size()][maxLength];
                int rowIter = rotated180.length - 1;
                for (int row = 0; row < rotated180.length; row++) {
                    int colIter = rotated180[0].length - 1;
                    for (int col = 0; col < rotated180[0].length; col++) {
                        if (rowIter < matrix.length && colIter < matrix[rowIter].length) {
                            rotated180[row][col] = matrix[rowIter][colIter];
                        }else{
                            rotated180[row][col] = ' ';
                        }
                        colIter--;
                    }
                    rowIter--;
                }

                printMatrix(rotated180);
                break;
            case 3:
                char[][] rotated270 = new char[maxLength][lines.size()];
                for (int col = 0; col < rotated270[0].length; col++) {
                    int iter = 0;
                    for (int row = rotated270.length - 1; row >= 0; row--) {
                        if (row < matrix[col].length && col < matrix.length) {
                            rotated270[iter][col] = matrix[col][row];
                        }else{
                            rotated270[iter][col] = ' ';
                        }
                        iter++;
                    }
                }

                printMatrix(rotated270);
                break;
        }

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
