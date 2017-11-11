package _08May2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

public class P02RoyalNonStop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        double[] prices = Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        BigDecimal lukankaPrice = new BigDecimal(prices[0]);
        BigDecimal rakiaPrice = new BigDecimal(prices[1]);
        BigDecimal turnover = new BigDecimal("0");
        int counter = 0;
        while (true) {
            String[] customer = reader.readLine().split(" ");
            if ("Royal".equals(customer[0])) {
                break;
            }

            int x = Integer.parseInt(customer[0]);
            int y = Integer.parseInt(customer[1]);
            BigDecimal value = new BigDecimal("0");
            if (x < y) {
                while (x > 0) {
                    value = value.add(new BigDecimal(((x + 1) * (y + 1)) * prices[x % 2]));
                    x--;
                }
                while (y > 0) {
                    value = value.add(new BigDecimal(((x + 1) * (y + 1)) * prices[x % 2]));
                    y--;
                }
            } else {

                while (y > 0 && x % 2 == 0) {
                    value = value.add(new BigDecimal(((x + 1) * (y + 1)) * prices[x % 2]));
                    y--;
                }
                while (y > 0 && x % 2 != 0) {
                    value = value.add(new BigDecimal(((x + 1) * (y + 1)) * prices[x % 2]));
                    y--;
                }
                while (x > 0) {
                    value = value.add(new BigDecimal(((x + 1) * (y + 1)) * prices[x % 2]));
                    x--;
                }
            }
            turnover = turnover.add(value);
            counter++;
        }

        DecimalFormat df = new DecimalFormat("0.000000");
        String output = df.format(turnover);
        System.out.println(output);
        System.out.println(counter);
    }
}