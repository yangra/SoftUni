import java.util.*;
import java.util.function.Consumer;

public class Tree<T> {

    private T value;
    private List<Tree<T>> children;

    public Tree(T value, Tree<T>... children) {
        this.value = value;
        this.children = new ArrayList<>(Arrays.asList(children));
    }

    // append output to builder
    public String print(int indent, StringBuilder builder) {
        this.printTree(this, indent, builder);
        return builder.toString();
    }

    private void printTree(Tree<T> node, int indent, StringBuilder builder) {
        builder.append(String.join("", Collections.nCopies(indent, "  "))).append(node.value).append("\n");
        for (Tree<T> child : node.children) {
            printTree(child, indent + 1, builder);
        }
    }

    public void each(Consumer<T> consumer) {
        consumer.accept(this.value);
        for (Tree<T> child : this.children) {
            child.each(consumer);
        }
    }

    public Iterable<T> orderDFS() {
        List<T> result = new ArrayList<>();
        orderTreeDFS(this, result);
        return result;
    }

    private void orderTreeDFS(Tree<T> node, List<T> result) {
        for (Tree<T> child : node.children) {
            orderTreeDFS(child, result);
        }
        result.add(node.value);
    }

    public Iterable<T> orderBFS() {
        List<T> result = new ArrayList<>();
        Deque<Tree<T>> queue = new ArrayDeque<>();

        queue.offer(this);
        while (queue.size() > 0) {
            Tree<T> node = queue.poll();
            for (Tree<T> child : node.children) {
                queue.offer(child);
            }
            result.add(node.value);
        }

        return result;
    }

}
