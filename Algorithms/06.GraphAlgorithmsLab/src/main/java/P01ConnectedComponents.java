import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01ConnectedComponents {
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        List<List<Integer>> graph = readGraph();

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);
        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.printf("Connected component: %s\n",
                    connectedComponent.toString().replaceAll("[\\[\\],]",""));
        }
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        visited = new boolean[graph.size()];
        List<Deque<Integer>> components = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                Deque<Integer> component = new ArrayDeque<>();
                component = DFS(i, graph, component);
                components.add(component);
            }
        }

        return components;
    }

    private static Deque<Integer> DFS(int node, List<List<Integer>> graph, Deque<Integer> component) {
        if (!visited[node]) {
            visited[node] = true;
            for (int i = 0; i < graph.get(node).size(); i++) {
                component = DFS(graph.get(node).get(i), graph, component);
            }
            component.offer(node);
        }

        return component;
    }

    private static List<List<Integer>> readGraph() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> graph = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            List<Integer> connectedComponents = new ArrayList<>();

            String line = reader.readLine();
            if (line.equals("")) {
                graph.add(connectedComponents);
                continue;
            }
            String[] nodes = line.split(" ");

            for (String node : nodes) {
                connectedComponents.add(Integer.parseInt(node));
            }

            graph.add(connectedComponents);
        }
        return graph;
    }
}
