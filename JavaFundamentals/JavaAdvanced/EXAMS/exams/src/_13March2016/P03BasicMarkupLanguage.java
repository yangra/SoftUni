package _13March2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03BasicMarkupLanguage {

    private static int rowNumber = 1;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern regex = Pattern.compile("<\\s*([a-z]+)\\s+(value\\s*=\\s*\"([0-9]+)\")?\\s*content\\s*=\\s*\"([^\"]+)\"\\s*/>");

        while (true) {
            String line = reader.readLine();
            if ("<stop/>".equals(line)) {
                break;
            }

            Matcher matcher = regex.matcher(line);
            if (matcher.find()) {
                String keyword = matcher.group(1);
                String content = matcher.group(4);
                if (content.length() > 0) {
                    switch (keyword) {
                        case "inverse":
                            inverseString(content);
                            break;
                        case "reverse":
                            reverseString(content);
                            break;
                        case "repeat":
                            int value = Integer.parseInt(matcher.group(3));
                            repeatString(content, value);
                            break;
                        default:
                            break;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static void repeatString(String content, int value) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value; i++) {
            builder.append(String.format("%d. ", rowNumber));
            builder.append(content + "\n");
            rowNumber++;
        }

        result.append(builder.toString());
    }

    private static void reverseString(String content) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d. ", rowNumber));
        for (int i = content.length() - 1; i >= 0; i--) {
            builder.append(content.charAt(i));
        }

        rowNumber++;
        result.append(builder.toString() + "\n");
    }

    private static void inverseString(String content) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d. ", rowNumber));
        for (int i = 0; i < content.length(); i++) {
            char curChar = content.charAt(i);
            if (Character.isAlphabetic(curChar) && Character.isLowerCase(curChar)) {
                builder.append(Character.toUpperCase(curChar));
            } else if (Character.isAlphabetic(curChar) && Character.isUpperCase(curChar)) {
                builder.append(Character.toLowerCase(curChar));
            } else {
                builder.append(curChar);
            }
        }

        rowNumber++;
        result.append(builder.toString() + "\n");
    }
}
