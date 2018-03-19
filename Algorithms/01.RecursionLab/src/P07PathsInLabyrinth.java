import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P07PathsInLabyrinth {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        String[] lab = new String[rows];
        for (int i = 0; i < rows; i++) {
            String row = reader.readLine();
            lab[i] = row;
        }

        findPaths(0, 0, 'O', lab, new boolean[rows][cols], new ArrayList<>());
    }

    private static void findPaths(int row, int col, char direction, String[] lab, boolean[][] visited, List<Character> way) {
        if (row < 0 || row >= lab.length ||
                col < 0 || col >= lab[0].length() ||
                visited[row][col] || lab[row].charAt(col) == '*') {
            return;
        }

        if (lab[row].charAt(col) == 'e') {
            for (int i = 1; i < way.size(); i++) {
                System.out.print(way.get(i));
            }
            System.out.println(direction);
            return;
        }

        visited[row][col] = true;
        way.add(direction);

        findPaths(row, col + 1, 'R', lab, visited, way);
        findPaths(row + 1, col, 'D', lab, visited, way);
        findPaths(row, col - 1, 'L', lab, visited, way);
        findPaths(row - 1, col, 'U', lab, visited, way);

        visited[row][col] = false;
        way.remove(way.size() - 1);
    }
}
