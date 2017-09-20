import java.util.Scanner;

public class P07CharacterMultiplier {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        String second = scanner.next();

        int result = 0;
        if (first.length() > second.length()) {
            result = getResult(second, first);
        } else {
            result = getResult(first, second);
        }
        System.out.println(result);
    }

    private static int getResult(String a, String b) {
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            result += a.charAt(i) * b.charAt(i);
        }

        for (int i = a.length(); i < b.length(); i++) {
            result += b.charAt(i);
        }

        return result;
    }
}
