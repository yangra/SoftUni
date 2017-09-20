import java.util.Scanner;

public class P09ExtractBitFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int position = scanner.nextInt();

        int result = (number>>position)&1;

        System.out.println(result);
    }
}
