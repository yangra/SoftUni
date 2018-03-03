import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Tuple<Double, Interval>> objects = new HashMap<>();
        int ticks = 0;

        String input = reader.readLine();
        while (true) {
            if (input.equals("start")) {
                break;
            }

            String[] params = input.split(" ");
            insertNewObject(objects, params);
            input = reader.readLine();
        }

        input = reader.readLine();
        while (true) {
            if (input.equals("end")) {
                break;
            }

            if (input.equals("tick")) {
                ticks++;
                findCollisions(objects, ticks);
            } else {
                ticks++;
                String[] params = input.split(" ");
                objects.remove(params[1]);
                insertNewObject(objects, params);
                findCollisions(objects, ticks);
            }

            input = reader.readLine();
        }
    }

    private static void insertNewObject(Map<String, Tuple<Double, Interval>> objects, String[] params) {
        String name = params[1];
        double X1 = Double.parseDouble(params[2]);
        double Y1 = Double.parseDouble(params[3]);
        Interval newInterval = new Interval(Y1, Y1 + 10);
        Tuple<Double, Interval> interval = new Tuple(X1, newInterval);
        objects.put(name, interval);
    }

    private static void findCollisions(Map<String, Tuple<Double, Interval>> objects, int ticks) {
        int step = 10;
        List<String> sortedKeys = new ArrayList<>(objects.keySet());
        sortedKeys.sort(Comparator.comparing(a -> objects.get(a).getFirstValue()));
        Map<String, Tuple<Double, Interval>> sorted = new LinkedHashMap<>();
        for (String s : sortedKeys) {
            sorted.putIfAbsent(s, objects.get(s));
        }


        Set<String> names = new HashSet<>();
        for (String key : sorted.keySet()) {
            List<Interval> current = new ArrayList<>();
            current.add(sorted.get(key).getSecondValue());
            List<String> collisions = sorted.keySet().stream()
                    .filter(k -> !k.equals(key) && !names.contains(k) &&
                            sorted.get(k).getFirstValue() >= sorted.get(key).getFirstValue() &&
                            sorted.get(k).getFirstValue() <= sorted.get(key).getFirstValue() + step &&
                            sorted.get(k).getSecondValue().intersects(sorted.get(key).getSecondValue()))
                    .collect(Collectors.toList());
            for (String collision : collisions) {
                System.out.printf("(%d) %s collides with %s\n", ticks, key, collision);
            }
            names.add(key);
        }

    }


}
