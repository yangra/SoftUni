package _07PathsWithGivenSum;

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

        int givenSum = Integer.parseInt(reader.readLine());
        Tree<Integer> root = nodesByValue.values().stream().filter(t -> t.getParent() == null).findFirst().get();

        List<Tree<Integer>> leaves = root.findPathsWithGivenSum(givenSum);

        System.out.printf("Paths of sum %d:\n", givenSum);

        for (Tree<Integer> leaf : leaves) {
            Deque<Integer> stack = new ArrayDeque<>();

            while (leaf != null) {
                stack.push(leaf.getValue());
                leaf = leaf.getParent();
            }
            Arrays.stream(stack.toArray()).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }

    }
}
