import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12LittleJohn {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern smallArrow = Pattern.compile(">[-]{5}>");
        Pattern mediumArrow = Pattern.compile(">{2}[-]{5}>");
        Pattern largeArrow = Pattern.compile(">{3}[-]{5}>{2}");

        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String line = reader.readLine();
            input.append(line).append("\r\n");
        }

        StringBuilder builder = new StringBuilder();
        Tuple result1 = countMatches(input.toString(), largeArrow);
        Tuple result2 = countMatches(result1.getText(), mediumArrow);
        Tuple result3 = countMatches(result2.getText(), smallArrow);
        builder.append(result3.getCounter()).append(result2.getCounter()).append(result1.getCounter());

        String intermediate = Integer.toBinaryString(Integer.valueOf(builder.toString()));
        StringBuilder inverseInterm = new StringBuilder();
        for (int i = intermediate.length() - 1; i >= 0; i--) {
            inverseInterm.append(intermediate.charAt(i));
        }

        String binaryResult = intermediate + inverseInterm.toString();
        Integer result = Integer.parseInt(binaryResult, 2);
        System.out.println(result);
    }

    private static Tuple countMatches(String input, Pattern pattern) {
        int counter = 0;
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            counter++;
        }

        input = matcher.replaceAll("arrow");
        return new Tuple(counter, input);
    }

    public static class Tuple {
        private Integer counter;
        private String text;

        Tuple(Integer counter, String text) {
            this.counter = counter;
            this.text = text;
        }

        Integer getCounter() {
            return counter;
        }

        String getText() {
            return text;
        }
    }
}