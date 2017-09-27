import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print((char) ('a' + row));
                System.out.print((char) ('a' + row + col));
                System.out.print((char) ('a' + row));
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
