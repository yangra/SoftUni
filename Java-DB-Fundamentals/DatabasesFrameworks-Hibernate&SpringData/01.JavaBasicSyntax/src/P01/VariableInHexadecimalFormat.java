package P01;

import java.util.Scanner;

public class VariableInHexadecimalFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer result = Integer.parseInt(scanner.nextLine(), 16);
        System.out.println(result);
    }
}
