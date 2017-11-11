package _28Feb2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class P03SoftUniNumerals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> correlation = new HashMap<>();
        correlation.put("aa", 0);
        correlation.put("aba", 1);
        correlation.put("bcc", 2);
        correlation.put("cc", 3);
        correlation.put("cdc", 4);

        String input = reader.readLine();
        StringBuilder builder = new StringBuilder();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            builder.append(input.charAt(i));
            for (Map.Entry<String, Integer> num : correlation.entrySet()) {
                if (builder.toString().equals(num.getKey())) {
                    number.append(num.getValue());
                    builder = new StringBuilder();
                    break;
                }
            }
        }

        String softNum = number.toString();
        BigDecimal result = BigDecimal.ZERO;
        for (int i = 0; i < softNum.length(); i++) {
            Integer digit = Integer.parseInt(softNum.charAt(softNum.length() - 1 - i) + "");
            BigDecimal multiplier = BigDecimal.ONE;
            for (int j = 0; j < i; j++) {
                multiplier = multiplier.multiply(new BigDecimal("5"));
            }
            result = result.add(multiplier.multiply(new BigDecimal(digit)));
        }

        System.out.println(result);

    }
}
