import java.util.Scanner;

public class P08MultiplyBigNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String bigNum = scanner.nextLine();
        int num = Integer.parseInt(scanner.nextLine());

        StringBuilder result = new StringBuilder();
        int additive = 0;
        for (int i = bigNum.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(bigNum.charAt(i));
            int multiplication = digit * num + additive;
            result.append(multiplication % 10);
            additive = (multiplication - (multiplication % 10)) / 10;
        }

        if (additive != 0) {
            result.append(additive);
        }

        while (result.length() > 1 && result.substring(result.length() - 1).equals("0")) {
            result.deleteCharAt(result.length() - 1);
        }

        System.out.println(result.reverse().toString());
    }
}
