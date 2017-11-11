package _19Feb2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03Ascent {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> words = new LinkedHashMap<>();
        while (true) {
            String message = reader.readLine();
            if ("ascend".equalsIgnoreCase(message)) {
                break;
            }

            for (Map.Entry<String, String> entry : words.entrySet()) {
                message = message.replace(entry.getKey(), entry.getValue());
            }

            Pattern regex = Pattern.compile("([_,])([a-zA-Z]+?)([0-9])");
            Matcher matcher = regex.matcher(message);

            while (matcher.find()) {
                String word = matcher.group(2);
                int num = Integer.parseInt(matcher.group(3));
                StringBuilder decoded = new StringBuilder();
                switch (matcher.group(1)) {
                    case "_":
                        for (int i = 0; i < word.length(); i++) {
                            decoded.append((char) ((int) word.charAt(i) - num));
                        }
                        words.put(matcher.group(), decoded.toString());
                        break;
                    case ",":
                        decoded = new StringBuilder();
                        for (int i = 0; i < word.length(); i++) {
                            decoded.append((char) ((int) word.charAt(i) + num));
                        }
                        words.put(matcher.group(), decoded.toString());
                        break;
                }

                message = message.replace(matcher.group(), decoded.toString());
            }

            System.out.println(message);
        }
    }
}
