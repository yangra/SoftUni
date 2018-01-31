package _01RootNode;

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

    public Tree<T> addNode(T value) {
        Tree<T> tree = new Tree<>(value);
        return tree;
    }

    public void addChild(Tree<T> node) {
        this.children.add(node);
        node.parent = this;
    }

    public Tree<T> getParent() {
        return this.parent;
    }

    public T getValue() {
        return this.value;
    }
}
