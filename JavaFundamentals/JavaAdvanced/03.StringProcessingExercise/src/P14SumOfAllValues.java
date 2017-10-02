import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P14SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keyString = reader.readLine();
        String textString = reader.readLine();
        Pattern startKeyPattern = Pattern.compile("^[a-zA-Z_]+(?=[0-9])");
        Pattern endKeyPattern = Pattern.compile("(?<=[0-9])[a-zA-Z_]+$");


        Matcher startKeyMatcher = startKeyPattern.matcher(keyString);
        Matcher endKeyMatcher = endKeyPattern.matcher(keyString);


        if (startKeyMatcher.find() && endKeyMatcher.find()) {
            String startKey = startKeyMatcher.group();
            String endKey = endKeyMatcher.group();

            Pattern number = Pattern.compile(startKey + "([0-9.]+)" + endKey);
            Matcher numberMatcher = number.matcher(textString);
            double sum = 0;
            while (numberMatcher.find()) {
                sum += Double.parseDouble(numberMatcher.group(1));
            }

            if (sum == 0) {
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            } else {
                if (sum % 1 == 0) {
                    System.out.printf("<p>The total value is: <em>%d</em></p>", (int) sum);
                } else {
                    System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
                }
            }

        } else {
            System.out.println("<p>A key is missing</p>");
        }


    }
}
