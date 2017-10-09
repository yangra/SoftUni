import java.util.Scanner;

public class P05RecursiveDrawing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfRows = Integer.parseInt(scanner.nextLine());

        drawRecursively(numberOfRows);
    }

    private static void drawRecursively(int numberOfRows) {
        if(numberOfRows<=0){
            return;
        }
        for (int i = 0; i < numberOfRows ; i++) {
            System.out.print("*");
        }
        System.out.println();
        drawRecursively(numberOfRows-1);
        for (int i = 0; i < numberOfRows ; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
}
