import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P04Salaries {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfEmployees = Integer.parseInt(reader.readLine());

        Map<Integer, List<Integer>> managedBy = new LinkedHashMap<>();
        Map<Integer, List<Integer>> employees = new LinkedHashMap<>();
        Map<Integer, Long> salaries = new HashMap<>();

        for (int i = 0; i < numberOfEmployees; i++) {
            managedBy.putIfAbsent(i, new ArrayList<>());
            employees.putIfAbsent(i, new ArrayList<>());
        }

        for (int i = 0; i < numberOfEmployees; i++) {
            String input = reader.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'Y') {
                    managedBy.get(j).add(i);
                    employees.get(i).add(j);
                }
            }
        }

        List<Integer> bosses = managedBy.keySet().stream().filter(k -> managedBy.get(k).size() == 0).collect(Collectors.toList());
        for (Integer boss : bosses) {
            DFS(boss, employees, salaries);
        }

        System.out.println(salaries.values().stream().reduce((a, b) -> a + b).get());
    }

    private static long DFS(Integer node, Map<Integer, List<Integer>> employees, Map<Integer, Long> salaries) {
        long salary = 0;
        if (employees.get(node).size() == 0) {
            salary = 1;
        }
        for (Integer employee : employees.get(node)) {
            if (salaries.containsKey(employee)) {
                salary += salaries.get(employee);
            } else {
                salary += DFS(employee, employees, salaries);
            }
        }

        salaries.putIfAbsent(node, salary);
        return salary;
    }
}
