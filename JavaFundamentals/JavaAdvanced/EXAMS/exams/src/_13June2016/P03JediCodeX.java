package _13June2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03JediCodeX {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder hay = new StringBuilder();
        for (int i = 0; i < n; i++) {
            hay.append(reader.readLine());
        }
        String pattern1 = reader.readLine();
        String pattern2 = reader.readLine();

        Pattern name = Pattern.compile(pattern1 + "([a-zA-Z]{" + pattern1.length() + "})(?=[^a-zA-Z])");
        Pattern message = Pattern.compile(pattern2 + "([a-zA-Z0-9]{" + pattern2.length() + "})(?=[^a-zA-Z0-9])");

        List<String> names = new ArrayList<>();
        List<String> messages = new ArrayList<>();

        Matcher nameMatcher = name.matcher(hay);
        Matcher messageMatcher = message.matcher(hay);
        while (nameMatcher.find()) {
            names.add(nameMatcher.group(1));
        }
        while (messageMatcher.find()) {
            messages.add(messageMatcher.group(1));
        }

        String[] indices = (reader.readLine().split("\\s+"));

        int counter = 0;
        for (int i = 0; i < names.size(); i++) {
            if (counter < indices.length) {
                int index = Integer.parseInt(indices[counter]);
                if (index > 0 && index <= messages.size()) {
                    System.out.print(names.get(i) + " - ");
                    System.out.println(messages.get(index - 1));
                } else {
                    i--;
                }
                counter++;
            } else {
                break;
            }
        }
    }
}