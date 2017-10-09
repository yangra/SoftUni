import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09PhoneNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> result = new ArrayList<>();
        StringBuilder input = new StringBuilder();
        while (true) {
            String line = reader.readLine();
            if ("END".equals(line)) {
                break;
            }

            input.append(line);
        }

        String pattern = "([A-Z][a-zA-Z]*)[^+]*?([+]??([0-9][()/.\\- ]*){2,})";
        String namePattern = "([A-Z][a-zA-Z]*)";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        Pattern nameRegex = Pattern.compile(namePattern);

        while (matcher.find()) {
            String match = matcher.group();

            Matcher nameMatcher = nameRegex.matcher(match);
            String name = "";
            while (nameMatcher.find()) {
                name = nameMatcher.group(1);
            }
            result.add(name);

            String number = matcher.group(2);
            number = number.replace("(", "")
                    .replace(")", "")
                    .replace(".", "")
                    .replace("-", "")
                    .replace(" ", "")
                    .replace("/", "");
            result.add(number);
        }

        if (result.size() > 1) {
            System.out.print("<ol>");
            for (int i = 0; i < result.size(); i += 2) {
                System.out.print("<li><b>" + result.get(i) + ":</b> " + result.get(i + 1) + "</li>");
            }
            System.out.print("</ol>");
        } else {
            System.out.println("<p>No matches!</p>");
        }
    }
}