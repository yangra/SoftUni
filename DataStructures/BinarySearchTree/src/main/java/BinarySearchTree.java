import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node node) {
        this.copy(node);
    }

    public Node getRoot() {
        return this.root;
    }

    public void insert(T value) {
        this.root = insert(this.root, value);
    }

    private Node insert(Node node, T value) {
        if (node == null) {
            return new Node(value);
        }

        int compare = node.value.compareTo(value);
        if (compare > 0) {
            node.left = insert(node.left, value);
        } else if (compare < 0) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    public boolean contains(T value) {
        return contains(this.root, value);
    }

    private boolean contains(Node node, T value) {
        if (node == null) {
            return false;
        }

        int compare = node.value.compareTo(value);

        if (compare > 0) {
            return contains(node.left, value);
        } else if (compare < 0) {
            return contains(node.right, value);
        } else {
            return true;
        }
    }

    public BinarySearchTree<T> search(T item) {
        return search(this.root, item);

    }

    private void copy(Node node) {
        if (node == null) {
            return;
        }

        this.insert(node.value);
        copy(node.left);
        copy(node.right);

    }

    private BinarySearchTree<T> search(Node node, T item) {
        if (node == null) {
            return null;
        }

        int compare = node.value.compareTo(item);
        if (compare > 0) {
            return search(node.left, item);
        } else if (compare < 0) {
            return search(node.right, item);
        } else {
            return new BinarySearchTree<>(node);
        }
    }

    public void eachInOrder(Consumer<T> consumer) {
        eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        eachInOrder(node.left, consumer);
        consumer.accept(node.value);
        eachInOrder(node.right, consumer);

    }

    public Iterable<T> range(T from, T to) {
        List<T> result = new ArrayList<>();
        range(this.root, result, from, to);
        return result;
    }

    private void range(Node node, List<T> result, T from, T to) {
        if (node == null) {
            return;
        }

        int compareStart = node.value.compareTo(from);
        int compareEnd = node.value.compareTo(to);

        if (compareEnd > 0) {
            range(node.left, result, from, to);
        }

        if (compareStart >= 0 && compareEnd <= 0) {

            range(node.left, result, from, to);
            result.add(node.value);
            range(node.right, result, from, to);
        }

        if (compareStart < 0) {
            range(node.right, result, from, to);
        }
    }

    class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}

