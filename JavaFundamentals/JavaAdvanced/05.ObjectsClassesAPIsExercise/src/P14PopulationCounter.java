import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class P14PopulationCounter {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> population = new LinkedHashMap<>();
        while (true) {
            String[] input = reader.readLine().split("\\|");
            if ("report".equalsIgnoreCase(input[0])) {
                break;
            }

            String city = input[0];
            String country = input[1];
            Long numberOfPeople = Long.valueOf(input[2]);


            if (!population.containsKey(country)) {
                population.put(country, new LinkedHashMap<>());
                population.get(country).put(city, numberOfPeople);
            } else {
                population.get(country).put(city, numberOfPeople);
            }
        }

        population = population.entrySet().stream()
                .sorted((a, b) -> {
                    Long operand1 = b.getValue().values().stream().mapToLong(v -> v).sum();
                    Long operand2 = a.getValue().values().stream().mapToLong(v -> v).sum();
                    return operand1.compareTo(operand2);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Long>> countryEntry : population.entrySet()) {

            Map<String, Long> cities = countryEntry.getValue().entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            Long countryPopulation = cities.values().stream().mapToLong(v -> v).sum();

            System.out.printf("%s (total population: %d)\n", countryEntry.getKey(), countryPopulation);

            for (Map.Entry<String, Long> cityEntry : cities.entrySet()) {
                System.out.printf("=>%s: %d\n", cityEntry.getKey(), cityEntry.getValue());
            }
        }
    }
}
