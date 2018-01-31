package _04MiddleNodes;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private T value;
    private Tree<T> parent;
    private List<Tree<T>> children;

    public Tree() {
        this.children = new ArrayList<>();
    }

    public Tree(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public Tree<T> getParent() {
        return this.parent;
    }

    public T getValue() {
        return this.value;
    }

    public Tree<T> addNode(T value) {
        Tree<T> tree = new Tree<>(value);
        return tree;
    }

    public void addChild(Tree<T> node) {
        this.children.add(node);
        node.parent = this;
    }

    public void print() {
        StringBuilder result = new StringBuilder();
        printNode(this, 0, result);
        System.out.println(result);
    }

    private void printNode(Tree<T> tree, int indent, StringBuilder builder) {
        builder.append(new String(new char[2 * indent]).replace("\0", " "))
                .append(tree.value).append("\n");
        for (Tree<T> child : tree.children) {
            printNode(child, indent + 1, builder);
        }
    }

    public List<T> findLeaves() {
        List<T> leafValues = new ArrayList<>();
        findLeaves(this, leafValues);
        return leafValues;
    }

    private void findLeaves(Tree<T> node, List<T> result) {
        if (node.children.isEmpty()) {
            result.add(node.value);
        }

        for (Tree<T> child : node.children) {
            findLeaves(child, result);
        }
    }

    public List<T> findMiddleNodes() {
        List<T> middleNodesValues = new ArrayList<>();
        findMiddle(this, middleNodesValues);
        return middleNodesValues;
    }

    private void findMiddle(Tree<T> node, List<T> result) {
        if (node.parent != null && !node.children.isEmpty()){
            result.add(node.value);
        }

        for (Tree<T> child : node.children) {
            findMiddle(child,result);
        }
    }
}
