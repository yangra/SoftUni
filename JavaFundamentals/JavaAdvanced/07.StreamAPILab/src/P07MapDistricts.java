import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P07MapDistricts {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> cities = new HashMap<>();
        List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));

        for (String token : tokens) {
            String[] tokenParams = token.split(":");
            String city = tokenParams[0];
            Integer population = Integer.valueOf(tokenParams[1]);

            cities.putIfAbsent(city, new ArrayList<>());
            cities.get(city).add(population);
        }

        Integer minPopulation = Integer.parseInt(reader.readLine());

        cities.entrySet().stream()
                .filter(getFilterByPopulationPredicate(minPopulation))
                .sorted(getSortedByDescendingPopulationComparator())
                .forEach(getPrintMapEntryConsumer());

    }

    private static Consumer<? super Map.Entry<String, List<Integer>>> getPrintMapEntryConsumer() {
        return me -> {
            System.out.printf("%s: ", me.getKey());
            me.getValue().stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(5)
                    .forEach(v -> System.out.print(v + " "));
            System.out.println();
        };
    }

    private static Comparator<? super Map.Entry<String, List<Integer>>> getSortedByDescendingPopulationComparator() {
        return (me1, me2) -> {
            Integer value1 = me1.getValue().stream().reduce((x, y) -> x + y).get();
            Integer value2 = me2.getValue().stream().reduce((x, y) -> x + y).get();
            return value2.compareTo(value1);
        };
    }


    private static Predicate<? super Map.Entry<String, List<Integer>>> getFilterByPopulationPredicate(int bound) {
        return me -> me != null &&
                me.getKey().length() > 0 &&
                me.getValue().size() > 0 &&
                me.getValue().stream()
                        .reduce((x, y) -> x + y).get()>bound;
    }
}
