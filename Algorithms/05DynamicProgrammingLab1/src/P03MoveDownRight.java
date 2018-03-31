import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03MoveDownRight {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());
        int[][] numbers = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                numbers[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < rows - 1; i++) {
            numbers[i + 1][0] += numbers[i][0];
        }

        for (int i = 0; i < cols-1; i++) {
            numbers[0][i + 1] += numbers[0][i];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                numbers[i][j] += Math.max(numbers[i - 1][j], numbers[i][j - 1]);
            }
        }

        int row = rows - 1;
        int col = cols - 1;

        StringBuilder builder = new StringBuilder();
        while (row >= 0 && col >= 0) {
            builder.insert(0,String.format(" [%d, %d]", row, col));
            if (row - 1 >= 0 && col - 1 >= 0) {
                if (numbers[row - 1][col] > numbers[row][col - 1]) {
                    row--;
                } else {
                    col--;
                }
            } else {
                if(col==0&&row==0){
                    break;
                }else if(col == 0){
                    row--;
                }else{
                    col--;
                }
            }
        }

        System.out.println(builder.toString().trim());
    }
}
