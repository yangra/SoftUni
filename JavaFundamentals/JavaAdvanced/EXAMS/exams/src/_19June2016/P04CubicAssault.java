package _19June2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class P04CubicAssault {

    private static final int numberOfMeteors = 1000000;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> regions = new HashMap<>();
        while (true) {
            String[] input = reader.readLine().split(" -> ");
            if ("Count em all".equalsIgnoreCase(input[0])) {
                break;
            }

            if (!regions.containsKey(input[0])) {
                Map<String, Long> meteors = new HashMap<>();
                meteors.put("Red", 0L);
                meteors.put("Green", 0L);
                meteors.put("Black", 0L);
                regions.put(input[0], meteors);
            }

            Long oldValue = regions.get(input[0]).get(input[1]);
            regions.get(input[0]).put(input[1], oldValue + Long.parseLong(input[2]));
            convertMeteors(regions,input[1]);
        }

        convertMeteors(regions,"Green");
        convertMeteors(regions,"Red");

        regions = regions.entrySet().stream().sorted((a, b) -> {
            int result = b.getValue().get("Black").compareTo(a.getValue().get("Black"));
            if (result == 0) {
                Integer op1 = a.getKey().length();
                Integer op2 = b.getKey().length();
                result = op1.compareTo(op2);
            }
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;

        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> x, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Long>> region : regions.entrySet()) {
            System.out.println(region.getKey());

            region.getValue().entrySet().stream()
                    .sorted((a, b) -> {
                        int result = b.getValue().compareTo(a.getValue());
                        if (result == 0) {
                            result = a.getKey().compareTo(b.getKey());
                        }
                        return result;
                    })
                    .forEach(me -> System.out.printf("-> %s : %s\n", me.getKey(), me.getValue()));
        }
    }

    private static void convertMeteors(Map<String, Map<String, Long>> regions, String color) {

        for (Map.Entry<String, Map<String, Long>> region : regions.entrySet()) {
            if (("Green".equals(color) || "Red".equals(color)) && region.getValue().get(color) >= 1000000) {
                Long oldValue = region.getValue().get(color);
                region.getValue().put(color.equals("Green")?"Red":"Black",
                        region.getValue().get(color.equals("Green")?"Red":"Black") + oldValue / 1000000);
                region.getValue().put(color, oldValue % 1000000);
            }
        }

    }
}