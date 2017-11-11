package _13June2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P04JediDreams {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());

        Map<String, List<String>> methods = new HashMap<>();

        Pattern regex = Pattern.compile("(\\w+)\\s*\\(");
        String method = "";
        for (int i = 0; i < rows; i++) {
            String row = reader.readLine();
            Matcher matcher = regex.matcher(row);
            if (row.trim().startsWith("static")) {
                if (matcher.find()) {
                    method = matcher.group(1);
                    methods.put(method, new ArrayList<>());
                }
            }

            while (matcher.find()) {
                String match = matcher.group(1);
                if (!match.equals("for") && !match.equals("while") &&
                        !match.equals("switch") && !match.equals("if")){
                    methods.get(method).add(match);
                }
            }
        }

        Comparator<Map.Entry<String, List<String>>> sortMap = (a, b) -> {
            Integer size2 = b.getValue().size();
            Integer size1 = a.getValue().size();
            int result = size2.compareTo(size1);
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        };
        methods.entrySet().stream()
                .sorted(sortMap)
                .forEach(me -> System.out.printf("%s -> %d -> %s\n", me.getKey(), me.getValue().size(),
                        me.getValue().stream()
                                .sorted((a, b) -> a.compareTo(b))
                                .collect(Collectors.joining(", "))));

    }
}
