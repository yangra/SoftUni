import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P02TopologicalSorting {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> graph = new HashMap<>();
        while (true) {
            String[] input = reader.readLine().split(" -> ");
            if (input[0].equals("")) {
                break;
            }


            graph.put(input[0], input.length > 1 ? Arrays.stream(input[1].split(", ")).collect(Collectors.toList()) : new ArrayList<>());
        }

        Collection<String> result = topSort(graph);

        System.out.println(result);
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        List<String> sorted = DFSSortinglAlgo(graph);
        return sorted;
    }

    private static List<String> DFSSortinglAlgo(Map<String, List<String>> graph) {
        List<String> result = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> cycleNodes = new HashSet<>();

        for (String key : graph.keySet()) {
            DFS(key, result, graph, visited, cycleNodes);

        }

        return result;
    }

    private static void DFS(String key, List<String> result, Map<String, List<String>> graph, Set<String> visited, Set<String> cycleNodes) {
        if(cycleNodes.contains(key)){
            throw new IllegalArgumentException("Cycle detected");
        }

        if(!visited.contains(key)){
            visited.add(key);
            cycleNodes.add(key);
            for (String child : graph.get(key)) {
                DFS(child,result, graph, visited, cycleNodes);
            }
            result.add(0,key);
            cycleNodes.remove(key);
        }
    }

    private static List<String> sourceRemovalAlgo(Map<String, List<String>> graph) {
        Map<String,Integer> predecessorCount = getPredecessorCount( graph);

        List<String> result = new ArrayList<>();
        while (true) {
            Optional<String> optionalNode  = predecessorCount.keySet().stream().filter(k->predecessorCount.get(k)==0).findAny();
            if(optionalNode.isPresent()){
                String nodeToRemove = optionalNode.get();

                for (String value : graph.get(nodeToRemove)) {
                   predecessorCount.put(value,predecessorCount.get(value)-1);
                }
                predecessorCount.remove(nodeToRemove);
                result.add(nodeToRemove);
                graph.remove(nodeToRemove);
            }else{
                break;
            }
        }

        if(graph.size()>0){
            throw new IllegalArgumentException("Graph has at least one cycle.");
        }

        return result;
    }

    private static Map<String, Integer> getPredecessorCount( Map<String,List<String>> graph) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String,List<String>> entry : graph.entrySet()) {
                result.putIfAbsent(entry.getKey(),0);
            for (String child : entry.getValue()) {
               result.putIfAbsent(child, 0);
               result.put(child, result.get(child)+1);
            }
        }
        return result;
    }

}
