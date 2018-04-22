import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P01DistanceBetweenVertices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int pairs = Integer.parseInt(reader.readLine());

        Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
        List<String> pairNodes = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            String[] input = reader.readLine().split(":");
            Integer node = Integer.parseInt(input[0]);
            graph.putIfAbsent(node, new ArrayList<>());
            if (input.length > 1) {
                List<Integer> children = Arrays.stream(input[1].split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                graph.put(node, children);
            }
        }

        for (int i = 0; i < pairs; i++) {
            String input = reader.readLine();
            pairNodes.add(input);
        }

        for (String pair : pairNodes) {
            String[] values = pair.split("-");
            int start = Integer.parseInt(values[0]);
            int end = Integer.parseInt(values[1]);

            int result = DFS(start, end, graph, new ArrayList<>(), Integer.MAX_VALUE);

            System.out.printf("{%d, %d} -> %d\n", start, end, result==Integer.MAX_VALUE? -1: result);
        }
    }

    private static int DFS(Integer node, Integer end, Map<Integer, List<Integer>> graph, List<Integer> visited, Integer result) {

        if (node.equals(end)) {
            if (result > visited.size()) {
                result = visited.size();
            }
            return result;
        }

        if (!visited.contains(node)) {
            visited.add(node);
            for (Integer child : graph.get(node)) {
                if (!visited.contains(child)) {
                    result = DFS(child, end, graph, visited, result);
                }
            }
            visited.remove(node);
        }

        return result;
    }
}
