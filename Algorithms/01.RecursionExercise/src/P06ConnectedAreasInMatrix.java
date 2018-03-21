import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P06ConnectedAreasInMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        String[] matrix = new String[rows];
        int cols = Integer.parseInt(reader.readLine());
        for (int i = 0; i < rows; i++) {
            String row = reader.readLine();
            matrix[i] = row;
        }

        boolean[][] visited = new boolean[rows][cols];
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length(); j++) {
                int[] area = new int[3];
                connectedAreas(i, j, matrix, visited, area, result);
            }
        }

        result = result.stream().sorted((a, b) -> {
            if (a[2] != b[2]) {
                return Integer.compare(b[2], a[2]);
            }
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        }).collect(Collectors.toList());

        System.out.printf("Total areas found: %d\n", result.size());
        for (int i = 1; i <= result.size(); i++) {
            System.out.printf("Area #%d at (%d, %d), size: %d\n",
                    i, result.get(i - 1)[0], result.get(i - 1)[1], result.get(i - 1)[2]);

        }
    }

    private static void connectedAreas(int row, int col, String[] matrix, boolean[][] visited, int[] area, List<int[]> result) {

        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length() || matrix[row].charAt(col) == '*' || visited[row][col]) {
            return;
        }

        area[0] = row;
        area[1] = col;
        traverseArea(row, col, matrix, visited, area);
        result.add(area);
    }

    private static void traverseArea(int row, int col, String[] matrix, boolean[][] visited, int[] area) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length() || matrix[row].charAt(col) == '*' || visited[row][col]) {
            return;
        }
        area[2]++;
        visited[row][col] = true;
        traverseArea(row + 1, col, matrix, visited, area);
        traverseArea(row - 1, col, matrix, visited, area);
        traverseArea(row, col + 1, matrix, visited, area);
        traverseArea(row, col - 1, matrix, visited, area);
    }
}
