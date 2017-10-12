import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05FilterByAge {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(reader.readLine());

        Map<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(", ");
            people.put(input[0], Integer.parseInt(input[1]));
        }

        String condition = reader.readLine();
        Integer age = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> filter = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);

        printFilteredPeople(people, filter, printer);
    }

    private static void printFilteredPeople(Map<String, Integer> people,
                                            Predicate<Integer> filter,
                                            Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (filter.test(person.getValue())) {
                printer.accept(person);
            }
        }
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        switch (format) {
            case "name age":
                return person -> System.out.printf("%s - %d\n", person.getKey(), person.getValue());
            case "name":
                return person -> System.out.printf("%s\n", person.getKey());
            case "age":
                return person -> System.out.printf("%d\n", person.getValue());

        }
        return person -> System.out.println("Invalid input");
    }

    private static Predicate<Integer> createTester(String condition, Integer age) {
        switch (condition) {
            case "younger":
                return x -> x < age;
            case "older":
                return x -> x >= age;
        }
        return x -> x != -1;
    }

}
