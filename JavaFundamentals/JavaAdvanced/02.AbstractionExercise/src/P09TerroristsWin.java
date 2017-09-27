import java.util.Scanner;

public class P09TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        String field = scanner.nextLine();

        if (!field.contains("|")) {
            System.out.println("No bombs found!");
        } else {
            while (field.contains("|")) {
                int leftBound = field.indexOf("|");
                int rightBound = field.indexOf("|", leftBound + 1);
                String insideBomb = field.substring(leftBound + 1, rightBound);
                int bombPower = 0;
                for (int i = 0; i < insideBomb.length(); i++) {
                    bombPower += (int) insideBomb.charAt(i);
                }
                bombPower %= 10;
                char[] result = field.toCharArray();
                for (int i = leftBound - bombPower < 0 ? 0 : leftBound - bombPower;
                     i <= (rightBound + bombPower >= field.length() ? field.length() - 1 : rightBound + bombPower);
                     i++) {

                    result[i] = '.';
                }
                field = new String(result);
//                field = String.valueOf(result);
            }
        }

        System.out.println(field);
    }
}
