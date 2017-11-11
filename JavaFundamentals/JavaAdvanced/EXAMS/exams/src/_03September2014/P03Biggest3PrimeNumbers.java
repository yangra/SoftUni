package _03September2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03Biggest3PrimeNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Pattern regex = Pattern.compile("\\(\\s*([-]?[0-9]+)\\s*\\)");
        Matcher matcher = regex.matcher(input);

        TreeSet<Integer> numbers = new TreeSet<>(Collections.reverseOrder());
        while (matcher.find()) {
            numbers.add(Integer.valueOf(matcher.group(1)));
        }

        int result = 0;
        int count = 0;
        for (Integer number : numbers) {
            if (isPrime(number)) {
                result += number;
                count++;
            }
            if (count == 3) {
                break;
            }
        }

        if (count==3) {
            System.out.println(result);
        } else {
            System.out.println("No");
        }
    }


    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
