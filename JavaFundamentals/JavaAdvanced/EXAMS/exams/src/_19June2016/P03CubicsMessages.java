package _19June2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03CubicsMessages {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> codedMessages = new ArrayList<>();
        while (true) {
            String message = reader.readLine();
            if ("Over!".equalsIgnoreCase(message)) {
                break;
            }

            int messageLength = Integer.parseInt(reader.readLine());

            Pattern regex = Pattern.compile("([0-9]+)([a-zA-Z]{" + messageLength + "})([^a-zA-Z]*)");
            Matcher matcher = regex.matcher(message);
            if (matcher.matches()) {
                String numbers = matcher.group(1) + matcher.group(3);
                String codedMessage = matcher.group(2);

                StringBuilder verificationCode = new StringBuilder();
                for (int i = 0; i < numbers.length(); i++) {
                    if (Character.isDigit(numbers.charAt(i))) {
                        int number = Integer.parseInt(numbers.charAt(i) + "");
                        if (number < messageLength) {
                            verificationCode.append(codedMessage.charAt(number));
                        } else {
                            verificationCode.append(" ");
                        }
                    }
                }

                System.out.printf("%s == %s\n", codedMessage, verificationCode.toString());
            }
        }
    }
}
