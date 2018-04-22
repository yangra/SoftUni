import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P05BreakCycles {

    private static Map<String, List<String>> graph = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> result = new ArrayList<>();

        String input = reader.readLine();

        while (input != null && !input.equals("")) {
            String[] split = input.split(" -> ");
            String node = split[0];
            List<String> children = Arrays.stream(split[1].split(" ")).collect(Collectors.toList());
            graph.putIfAbsent(node, new ArrayList<>());
            graph.get(node).addAll(children);

            input = reader.readLine();
        }


        for (Map.Entry<String, List<String>> nodeEntry : new ArrayList<>(graph.entrySet())) {

            String start = nodeEntry.getKey();

            List<String> edges = graph.get(start);
            edges.sort(Comparator.naturalOrder());
            for (String end : new ArrayList<>(edges)) {
                graph.get(start).remove(end);
                graph.get(end).remove(start);
                if (hasPath(start, end)) {
                    result.add(String.format("%s - %s", start, end));
                } else {
                    graph.get(start).add(end);
                    graph.get(end).add(start);
                }
            }
        }

        System.out.printf("Edges to remove: %d\n", result.size());
        result.forEach(System.out::println);
    }

    private static boolean hasPath(String start, String end) {
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<String>();
        queue.offer(start);
        visited.add(start);

        while (queue.size() > 0) {

            String node = queue.poll();
            List<String> children = graph.get(node);
            children.sort(Comparator.naturalOrder());

            for (String child : children) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.offer(child);

                    if (child.equals(end)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
