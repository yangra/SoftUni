package _13March2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P01ArrangeNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, String> numbers = new HashMap<>();
        numbers.put('1',"one");
        numbers.put('2',"two");
        numbers.put('3',"three");
        numbers.put('4',"four");
        numbers.put('5',"five");
        numbers.put('6',"six");
        numbers.put('7',"seven");
        numbers.put('8',"eight");
        numbers.put('9',"nine");
        numbers.put('0',"zero");

        List<String[]> converted = new ArrayList<>();
        String[] integers = reader.readLine().split(", ");
        for (int i = 0; i < integers.length; i++) {
            StringBuilder number = new StringBuilder();
            for (int j = 0; j < integers[i].length(); j++) {
                number.append(numbers.get(integers[i].charAt(j)));
            }
            String[] num = new String[2];
            num[0] = integers[i];
            num[1] = number.toString();
            converted.add(num);
        }

        String result = converted.stream().sorted((a,b)->a[1].compareTo(b[1])).map(entry->entry[0]).collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
