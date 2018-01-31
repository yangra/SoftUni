package _05DeepestNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Tree<Integer>> nodesByValue = new HashMap<>();
        Tree<Integer> tree = new Tree<>();
        int numberOfNodes = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfNodes - 1; i++) {
            int[] pair = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (!nodesByValue.containsKey(pair[0])) {
                nodesByValue.put(pair[0], tree.addNode(pair[0]));
            }
            if (!nodesByValue.containsKey(pair[1])) {
                nodesByValue.put(pair[1], tree.addNode(pair[1]));
                nodesByValue.get(pair[0]).addChild(nodesByValue.get(pair[1]));
            }
        }

        Tree<Integer> root = nodesByValue.values().stream().filter(t -> t.getParent() == null).findFirst().get();

        Tree<Integer> result = root.findDeepestNode();
        System.out.print("Deepest node: " + result.getValue() );

    }
}
