package P03;

import java.util.Scanner;

public class ReverseCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] result = new char[3];
        for (int i = 0; i < 3; i++) {
            result[i] = scanner.next().charAt(0);
        }
        for (int i = 0; i < 3 ; i++) {
            System.out.print(result[result.length-i-1]);
        }
    }
}
