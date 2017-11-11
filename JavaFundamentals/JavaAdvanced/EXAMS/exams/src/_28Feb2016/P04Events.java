package _28Feb2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P04Events {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, List<String>>> events = new TreeMap<>();
        Pattern regex = Pattern.compile("^#([a-zA-Z]+):\\s*@([a-zA-Z]+)\\s*([0-9]{2}):([0-9]{2})$");
        Integer n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            Matcher matcher = regex.matcher(input);
            if (matcher.find()) {

                Integer hour = Integer.parseInt(matcher.group(3));
                Integer minutes = Integer.parseInt(matcher.group(4));
                if (hour >= 0 && hour < 24 && minutes >= 0 && minutes < 60) {
                    String person = matcher.group(1);
                    String place = matcher.group(2);
                    events.putIfAbsent(place, new TreeMap<>());
                    events.get(place).putIfAbsent(person, new ArrayList<>());
                    events.get(place).get(person).add(matcher.group(3) + ":" + matcher.group(4));
                }
            }
        }


        Comparator<String> comp = (a, b) -> {
            int result = Integer.compare(Integer.parseInt(a.substring(0, 2)), Integer.parseInt(b.substring(0, 2)));
            if (result == 0) {
                result = Integer.compare(Integer.parseInt(a.substring(3)), Integer.parseInt(b.substring(3)));
            }
            return result;
        };
        List<String> places = Arrays.stream(reader.readLine().split(",")).collect(Collectors.toList());

        for (Map.Entry<String, Map<String, List<String>>> entry : events.entrySet()) {
            if(places.contains(entry.getKey())){
                System.out.printf("%s:\n",entry.getKey());
                int counter = 1;
                for (Map.Entry<String,List<String>> me : entry.getValue().entrySet()) {
                    System.out.printf("%d. %s -> %s\n",counter, me.getKey(), me.getValue().stream()
                                    .sorted(comp)
                                    .collect(Collectors.joining(", ")));
                    counter++;
                }
            }
        }

    }
}
