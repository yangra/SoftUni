import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07ValidUsernames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String pattern = "^[a-zA-Z0-9-_]{3,16}$";

        StringBuilder result = new StringBuilder();
        boolean allowPrint = false;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(line);

            if (matcher.find()) {
                result.append("valid\n");
                allowPrint = true;
            } else if ("".equals(line)) {
            } else {
                result.append("invalid\n");
            }
        }

        if (allowPrint) {
            System.out.println(result.toString());
        }
    }
}