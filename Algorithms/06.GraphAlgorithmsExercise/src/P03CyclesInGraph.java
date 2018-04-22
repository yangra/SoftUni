import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P03CyclesInGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> graph = new LinkedHashMap<>();
        String input = reader.readLine();
        while (input != null && !input.equals("")) {
            String[] split = input.split("–");
            graph.putIfAbsent(split[0], new ArrayList<>());
            graph.putIfAbsent(split[1], new ArrayList<>());
            graph.get(split[0]).add(split[1]);
            graph.get(split[1]).add(split[0]);
            input = reader.readLine();
        }


        System.out.print("Acyclic: ");
        for (String key : graph.keySet()) {
            List<String> cycleNodes = new ArrayList<>();
            List<String> visited = new ArrayList<>();
            if (DFS(key, cycleNodes, visited, graph, false, null)) {
                System.out.print("No");
                return;
            }
        }

        System.out.println("Yes");

    }

    private static boolean DFS(String node, List<String> cycleNodes, List<String> visited,
                               Map<String, List<String>> graph, boolean isCyclic, String parent) {
        if (cycleNodes.contains(node)) {
            return true;
        }
        if (!visited.contains(node)) {
            visited.add(node);
            cycleNodes.add(node);
            for (String child : graph.get(node)) {
                if (!child.equals(parent)) {
                    isCyclic = DFS(child, cycleNodes, visited, graph, isCyclic, node);
                    if (isCyclic) {
                        break;
                    }
                }
            }

            visited.remove(node);
            cycleNodes.remove(node);
        }

        return isCyclic;
    }
}