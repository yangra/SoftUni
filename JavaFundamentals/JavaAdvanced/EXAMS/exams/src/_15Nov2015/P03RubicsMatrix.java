package _15Nov2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P03RubicsMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][size[1]];
        int counter = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = counter;
                counter++;
            }
        }

        int moves = Integer.parseInt(reader.readLine());
        for (int i = 0; i < moves; i++) {
            String[] move = reader.readLine().split("\\s+");
            int beginning = Integer.parseInt(move[0]);
            String direction = move[1];
            int rolls = Integer.parseInt(move[2]);

            switch (direction) {
                case "right":
                    rollRight(matrix, beginning, rolls);
                    break;
                case "left":
                    rollLeft(matrix, beginning, rolls);
                    break;
                case "up":
                    rollUp(matrix, beginning, rolls);
                    break;
                default:
                    rollDown(matrix, beginning, rolls);
                    break;


            }
        }

        counter = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (counter == matrix[i][j]) {
                    System.out.println("No swap required");
                } else {
                    boolean swapped = false;
                    for (int k = 0; k < matrix.length; k++) {
                        for (int m = 0; m < matrix[0].length; m++) {
                            if (matrix[k][m] == counter) {
                                swap(matrix, i, j, k, m);
                                System.out.printf("Swap (%d, %d) with (%d, %d)\n", i, j, k, m);
                                swapped = true;
                                break;
                            }
                        }
                        if (swapped) {
                            break;
                        }
                    }
                }
                counter++;
            }
        }

    }

    private static void swap(int[][] matrix, int i, int j, int k, int m) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][m];
        matrix[k][m] = temp;
    }

    private static void rollDown(int[][] matrix, int col, int rolls) {
        for (int i = 0; i < rolls % matrix.length; i++) {
            ArrayDeque<Integer> previous = new ArrayDeque<>();
            previous.offer(matrix[0][col]);
            for (int j = 0; j < matrix.length - 1; j++) {
                previous.offer(matrix[j + 1][col]);
                matrix[j + 1][col] = previous.poll();
            }
            matrix[0][col] = previous.poll();
        }
    }

    private static void rollUp(int[][] matrix, int col, int rolls) {
        for (int i = 0; i < rolls % matrix.length; i++) {
            ArrayDeque<Integer> previous = new ArrayDeque<>();
            previous.offer(matrix[matrix.length - 1][col]);
            for (int j = matrix.length - 2; j >= 0; j--) {
                previous.offer(matrix[j][col]);
                matrix[j][col] = previous.poll();
            }
            matrix[matrix.length - 1][col] = previous.poll();
        }
    }

    private static void rollLeft(int[][] matrix, int row, int rolls) {
        for (int i = 0; i < rolls % matrix[0].length; i++) {
            ArrayDeque<Integer> previous = new ArrayDeque<>();
            previous.offer(matrix[row][matrix[0].length - 1]);
            for (int j = matrix[0].length - 2; j >= 0; j--) {
                previous.offer(matrix[row][j]);
                matrix[row][j] = previous.poll();
            }
            matrix[row][matrix[0].length - 1] = previous.poll();
        }
    }

    private static void rollRight(int[][] matrix, int row, int rolls) {
        for (int i = 0; i < rolls % matrix[0].length; i++) {
            ArrayDeque<Integer> previous = new ArrayDeque<>();
            previous.offer(matrix[row][0]);
            for (int j = 0; j < matrix[0].length - 1; j++) {
                previous.offer(matrix[row][j + 1]);
                matrix[row][j + 1] = previous.poll();
            }
            matrix[row][0] = previous.poll();
        }
    }
}
