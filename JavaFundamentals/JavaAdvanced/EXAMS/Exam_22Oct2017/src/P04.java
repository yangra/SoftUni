import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        StringBuilder text = new StringBuilder();
        text.append(input);

        while (true) {
            String pattern = reader.readLine();
            if ("Print".equalsIgnoreCase(pattern)) {
                break;
            }

            pattern = replaceSpecialChars(pattern);
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(text);
            while (matcher.find()) {
                Integer start = matcher.start();
                Integer end = matcher.end();
                String match = matcher.group();
                StringBuilder reversed = new StringBuilder();
                for (int i = match.length() - 1; i >= 0; i--) {
                    reversed.append(match.charAt(i));
                }
                text.replace(start, end, reversed.toString());
            }
        }

        System.out.println(text.toString());
    }

    private static String replaceSpecialChars(String pattern) {
        StringBuilder newPattern = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            if (Character.isDigit(pattern.charAt(i))) {
                newPattern.append(pattern.charAt(i));
                continue;
            }
            if (Character.isLowerCase(pattern.charAt(i))) {
                newPattern.append(pattern.charAt(i));
                continue;
            }
            if (Character.isUpperCase(pattern.charAt(i))) {
                newPattern.append(pattern.charAt(i));
                continue;
            }

            switch (pattern.charAt(i)) {
                case '.':
                    newPattern.append("\\.");
                    break;
                case ']':
                    newPattern.append("\\]");
                    break;
                case '[':
                    newPattern.append("\\[");
                    break;
                case '*':
                    newPattern.append("\\*");
                    break;
                case '?':
                    newPattern.append("\\?");
                    break;
                case '{':
                    newPattern.append("\\{");
                    break;
                case '}':
                    newPattern.append("\\}");
                    break;
                case '^':
                    newPattern.append("\\^");
                    break;
                case '%':
                    newPattern.append("[^\\s]*");
                    break;
                case '\\':
                    newPattern.append("\\\\");
                    break;
                case '+':
                    newPattern.append("\\+");
                    break;
                case '(':
                    newPattern.append("\\(");
                    break;
                case ')':
                    newPattern.append("\\)");
                    break;
                case '$':
                    newPattern.append("\\$");
                    break;
                case '|':
                    newPattern.append("\\|");
                    break;
                case '>':
                    newPattern.append("\\>");
                    break;
                case '<':
                    newPattern.append("\\<");
                    break;
                default:
                    newPattern.append(pattern.charAt(i));
                    break;

            }
        }

        return newPattern.toString();
    }
}
