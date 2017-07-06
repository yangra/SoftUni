package P10;


import java.util.Scanner;

public class IndexOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] letters = scanner.nextLine().toCharArray();
        for (int i = 0; i < letters.length ; i++) {
            int value = letters[i] - 97;
            System.out.println(letters[i]+ " -> "+ value);
        }
    }
}
