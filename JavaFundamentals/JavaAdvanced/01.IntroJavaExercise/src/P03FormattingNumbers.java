import java.util.Scanner;

public class P03FormattingNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        System.out.printf("|%-10s|", Integer.toHexString(a).toUpperCase());
        System.out.print((String.format("%10s|", Integer.toBinaryString(a)).replace(' ', '0')));
        System.out.printf("%10.2f|", b);
        System.out.print(String.format("%-10.3f|", c));
    }
}
