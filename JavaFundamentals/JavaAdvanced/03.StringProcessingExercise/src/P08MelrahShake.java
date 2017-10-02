import java.util.Scanner;

public class P08MelrahShake {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String pattern = scanner.nextLine();

        while (true) {
            int startIndex = text.indexOf(pattern);
            int endIndex = text.lastIndexOf(pattern);
            if (startIndex == endIndex || startIndex == -1||"".equals(pattern)) {
                System.out.println("No shake.");
                break;
            }

            text = text.substring(0, endIndex) + text.substring(endIndex + pattern.length());
            text = text.substring(0, startIndex) + text.substring(startIndex + pattern.length());
            int removeIndex = pattern.length() / 2;
            pattern = pattern.substring(0, removeIndex) + pattern.substring(removeIndex + 1);
            System.out.println("Shaked it.");
        }

        System.out.println(text);
    }
}
