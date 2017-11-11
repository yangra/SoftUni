package _15Nov2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P04LogParser {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, List<String>>> log = new LinkedHashMap<>();
        String pattern = "\"Project\":\\s+\\[\"(.+?)\"\\],\\s+\"Type\":\\s+\\[\"(Critical|Warning)\"\\],\\s+\"Message\":\\s+\\[\"(.+?)\"\\]";
        Pattern regex = Pattern.compile(pattern);
        while (true) {
            String info = reader.readLine();
            if ("END".equals(info)) {
                break;
            }

            Matcher matcher = regex.matcher(info);
            if (matcher.find()) {
                String projectName = matcher.group(1);
                String typeError = matcher.group(2);
                String messageError = matcher.group(3);

                log.putIfAbsent(projectName, new LinkedHashMap<>());
                log.get(projectName).putIfAbsent("Critical", new ArrayList<>());
                log.get(projectName).putIfAbsent("Warning", new ArrayList<>());
                if (typeError.equals("Critical")) {
                    log.get(projectName).get("Critical").add(messageError);
                } else {
                    log.get(projectName).get("Warning").add(messageError);
                }
            }
        }

        Comparator<String> comparator = (a, b) -> {
            int result = Integer.compare(a.length(), b.length());
            if (result == 0) {
                result = a.compareTo(b);
            }
            return result;
        };

        String finalResult = log.entrySet().stream()
                .sorted((a, b) -> {
                    int numberOfErrors1 = a.getValue().entrySet().stream().mapToInt(me -> me.getValue().size()).sum();
                    int numberOfErrors2 = b.getValue().entrySet().stream().mapToInt(me -> me.getValue().size()).sum();
                    int result = Integer.compare(numberOfErrors2, numberOfErrors1);
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                }).map(me -> getReport(me, comparator)).collect(Collectors.joining("\n"));

        System.out.println(finalResult);
    }

    private static String getReport(Map.Entry<String, Map<String, List<String>>> entry, Comparator<String> comparator) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s:\n", entry.getKey()));
        builder.append(String.format("Total Errors: %s\n", entry.getValue().entrySet().stream().mapToInt(me -> me.getValue().size()).sum()));
        builder.append(String.format("Critical: %s\n", entry.getValue().get("Critical").size()));
        builder.append(String.format("Warnings: %s\n", entry.getValue().get("Warning").size()));
        builder.append(("Critical Messages:\n"));

        if (entry.getValue().get("Critical").size() > 0) {
        entry.getValue().get("Critical").stream().sorted(comparator).forEach(s -> builder.append(String.format("--->%s\n", s)));}
        else{
            builder.append("--->None\n");
        }
        builder.append(("Warning Messages:\n"));
        if (entry.getValue().get("Warning").size() > 0) {
            entry.getValue().get("Warning").stream().sorted(comparator).forEach(s -> builder.append(String.format("--->%s\n", s)));
        } else {
            builder.append("--->None\n");
        }
        return builder.toString();
    }
}