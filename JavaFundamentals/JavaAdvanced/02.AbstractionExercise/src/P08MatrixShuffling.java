import java.util.Scanner;

public class P08MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] dims = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dims[0]);
        int cols = Integer.parseInt(dims[1]);

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = line[col];
            }
        }

        while (true) {
            String[] command = scanner.nextLine().split("\\s+");
            if (command[0].equals("END")) {
                break;
            }

            if (!command[0].equals("swap") && command.length != 5) {
                System.out.println("Invalid input!");
            } else {
                try {
                    int rowOne = Integer.parseInt(command[1]);
                    int colOne = Integer.parseInt(command[2]);
                    int rowTwo = Integer.parseInt(command[3]);
                    int colTwo = Integer.parseInt(command[4]);

                    if (rowOne >= 0 && rowOne < matrix.length &&
                            colOne >= 0 && colOne < matrix[0].length &&
                            rowTwo >= 0 && rowTwo < matrix.length &&
                            colTwo >= 0 && colTwo < matrix[0].length) {
                        String temp = matrix[rowOne][colOne];
                        matrix[rowOne][colOne] = matrix[rowTwo][colTwo];
                        matrix[rowTwo][colTwo] = temp;
                    }else {
                        System.out.println("Invalid input!");
                        continue;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Invalid input!");
                    continue;
                }

                printArray(matrix);
            }
        }
    }

    private static void printArray(String[][] matrix) {
        for (String[] row : matrix) {
            for (String element :row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
