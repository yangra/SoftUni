import java.util.Scanner;

public class P04UnicodeCharacters {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            stringBuilder.append("\\u").append(Integer.toHexString(text.charAt(i)|0x10000).substring(1));
        }

        System.out.println(stringBuilder.toString());
    }
}
