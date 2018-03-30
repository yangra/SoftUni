import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p02_setCover {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }

        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }

        List<int[]> chosenSets = chooseSets(sets, universe);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chosenSets.size(); i++) {
            sb.append("{ ");
            for (int j = 0; j < chosenSets.get(i).length; j++) {
                sb.append(chosenSets.get(i)[j]);
                if (j != chosenSets.get(i).length - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }\n");
        }

        System.out.println(sb.toString());
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        List<int[]> result = new ArrayList<>();
        List<int[]> modSets = new ArrayList<>(sets);
        List<Integer> modifiableUniverse = Arrays.stream(universe).boxed().collect(Collectors.toList());
        while (modifiableUniverse.size() > 0 && modSets.size() > 0) {
            int[] chosen = modSets.stream().sorted((a, b) -> {
                long countA = Arrays.stream(a).filter(modifiableUniverse::contains).count();
                long countB = Arrays.stream(b).filter(modifiableUniverse::contains).count();
                return Long.compare(countB, countA);
            }).findFirst().get();

            result.add(chosen);
            for (int element : chosen) {
                if (modifiableUniverse.contains(element)) {
                    modifiableUniverse.remove(Integer.valueOf(element));
                }
            }
            modSets.remove(chosen);
        }

        return result;
    }
}

