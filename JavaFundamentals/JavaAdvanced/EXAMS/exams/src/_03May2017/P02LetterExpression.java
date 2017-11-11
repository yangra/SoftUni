package _03May2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02LetterExpression {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern regex = Pattern.compile("([-]*\\.*[0-9]+(\\.[0-9]+)*)([^.0-9-]+?)(?=[0-9-.])");
        Pattern numberPattern = Pattern.compile("([-]*\\.*[0-9]+(\\.[0-9]+)*)");
        Matcher matcher = regex.matcher(input);

        Deque<String> deque = new ArrayDeque<>();
        BigDecimal result = BigDecimal.ZERO;
        int lastIndex = 0;
        while (matcher.find()) {
            lastIndex = matcher.end();
            BigDecimal number = new BigDecimal(matcher.group(1));
            result = updateResult(deque, result, number);

            if (matcher.group(3).length() % 2 != 0) {
                deque.offer("-");
            } else {
                deque.offer("+");
            }
        }

        String lastNumber = input.substring(lastIndex);
        Matcher numberMatcher = numberPattern.matcher(lastNumber);
        if (numberMatcher.find()) {
            BigDecimal lastNum = new BigDecimal(numberMatcher.group());
            result = updateResult(deque, result, lastNum);
        }
        DecimalFormat df = new DecimalFormat("0.#######");
        System.out.println(df.format(result));

    }

    private static BigDecimal updateResult(Deque<String> deque, BigDecimal result, BigDecimal lastNum) {
        if (deque.size() > 0) {
            String sign = deque.poll();
            if (sign.equals("+")) {
                result = result.add(lastNum);
            } else {
                result = result.subtract(lastNum);
            }
        }else{
            result = result.add(lastNum);
        }
        return result;
    }
}
