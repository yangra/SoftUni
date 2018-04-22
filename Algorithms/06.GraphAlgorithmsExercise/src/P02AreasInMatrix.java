import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class P02AreasInMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int numberOfRows = Integer.parseInt(reader.readLine());
        String inputRow = reader.readLine();
        char[][] matrix = new char[numberOfRows][inputRow.length()];
        boolean[][] visited = new boolean[numberOfRows][inputRow.length()];
        for (int i = 0; i < inputRow.length(); i++) {
            matrix[0][i] = inputRow.charAt(i);
        }

        for (int i = 1; i < numberOfRows; i++) {
            inputRow = reader.readLine();
            for (int j = 0; j < inputRow.length(); j++) {
                matrix[i][j] = inputRow.charAt(j);

            }
        }

        Map<Character, Integer> areas = new TreeMap<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if(DFS(matrix[row][col], row, col, matrix, visited, false)){
                    areas.putIfAbsent(matrix[row][col], 0);
                    areas.put(matrix[row][col], areas.get(matrix[row][col])+1);
                }
            }
        }

        System.out.println("Areas: " + areas.values().stream().reduce((a,b)-> a+b).get());
        for (Character letter : areas.keySet()) {
            System.out.println("Letter '"+ letter+ "' -> "+ areas.get(letter));
        }
    }

    private static boolean DFS(char letter, int row, int col, char[][] matrix, boolean[][] visited, boolean changed) {
        if (letter == matrix[row][col]) {
            if (!visited[row][col]) {
                visited[row][col] = true;
                changed = true;
                if (row - 1 >= 0) {
                    DFS(letter, row - 1, col, matrix, visited, changed);
                }
                if (row + 1 < matrix.length) {
                    DFS(letter, row + 1, col, matrix, visited, changed);
                }
                if (col - 1 >= 0) {
                    DFS(letter, row, col - 1, matrix, visited, changed);
                }
                if (col + 1 < matrix[0].length) {
                    DFS(letter, row, col + 1, matrix, visited, changed);
                }
            }
        }

        return changed;
    }
}
