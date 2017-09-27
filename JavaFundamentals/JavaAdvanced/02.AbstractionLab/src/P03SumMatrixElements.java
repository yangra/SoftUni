import java.util.Scanner;

public class P03SumMatrixElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        System.out.println(rows);
        System.out.println(cols);

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                sum += Integer.parseInt(line[col]);
            }
        }

        System.out.println(sum);
    }
}
