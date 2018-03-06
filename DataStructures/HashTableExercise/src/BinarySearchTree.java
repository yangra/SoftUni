import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;
    private int nodesCount;

    public BinarySearchTree() {
    }

    private BinarySearchTree(Node root) {
        this.preOrderCopy(root);
    }

    private void preOrderCopy(Node node) {
        if (node == null) {
            return;
        }

        this.insert(node.value);
        this.preOrderCopy(node.left);
        this.preOrderCopy(node.right);
    }

    public Node getRoot() {
        return this.root;
    }

    public int getNodesCount() {
        throw new UnsupportedOperationException();
    }

    public int count() {
        return this.count(this.root);
    }

    private int count(Node node) {
        if (node == null) {
            return 0;
        }

        node.count = 1 + this.count(node.left) + this.count(node.right);

        return node.count;
    }

    public void insert(T value) {

        if (this.root == null) {
            this.root = new Node(value);
            this.nodesCount++;
            this.root.count = 1;
            return;
        }

        Node parent = null;
        Node current = this.root;
        while (current != null) {
            parent = current;
            parent.childrenCount++;

            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                return;
            }
        }

        Node newNode = new Node(value);
        this.nodesCount++;
        if (value.compareTo(parent.value) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public boolean contains(T value) {
        Node current = this.root;
        while (current != null) {
            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                break;
            }
        }

        return current != null;
    }

    public BinarySearchTree<T> search(T item) {
        Node current = this.root;
        while (current != null) {
            if (item.compareTo(current.value) < 0) {
                current = current.left;
            } else if (item.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                break;
            }
        }

        return new BinarySearchTree<>(current);
    }

    public void eachInOrder(Consumer<T> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.left, consumer);
        consumer.accept(node.value);
        this.eachInOrder(node.right, consumer);
    }

    public Iterable<T> range(T from, T to) {
        Deque<T> queue = new LinkedList<>();
        this.range(this.root, queue, from, to);
        return queue;
    }

    private void range(Node node, Deque<T> queue, T startRange, T endRange) {
        if (node == null) {
            return;
        }

        int compareStart = startRange.compareTo(node.value);
        int compareEnd = endRange.compareTo(node.value);
        if (compareStart < 0) {
            this.range(node.left, queue, startRange, endRange);
        }
        if (compareStart <= 0 && compareEnd >= 0) {
            queue.addLast(node.value);
        }
        if (compareEnd > 0) {
            this.range(node.right, queue, startRange, endRange);
        }
    }

    private T minValue(Node root) {
        T minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }

        return minv;
    }

    public void deleteMin() {
        if (this.root == null) {
            throw new IllegalArgumentException("Tree is empty!");
        }

        Node min = this.root;
        Node parent = null;

        while (min.left != null) {
            parent = min;
            parent.childrenCount--;
            min = min.left;
        }

        if (parent == null) {
            this.root = this.root.right;
        } else {
            parent.left = min.right;
        }

        this.nodesCount--;
    }

    public void deleteMax() {
        if (this.root == null) {
            throw new IllegalArgumentException("Tree is empty!");
        }

        Node parent = null;
        Node max = this.root;

        while (max.right != null) {
            parent = max;
            parent.childrenCount--;
            max = max.right;
        }

        if (parent == null) {
            this.root = max.left;
        } else {
            parent.right = max.left;
        }

        this.nodesCount--;

    }

    public T ceil(T element) {
        return ceil(this.root, element);

    }

    private T ceil(Node node, T element) {
        if (node == null) {
            return null;
        }

        if (node.value.compareTo(element) < 0) {
            return ceil(node.right, element);
        }

        T ceil = ceil(node.left, element);

        if (ceil == null) {
            return node.value;
        }

        return ceil;
    }


    public T floor(T element) {

        Deque<T> stack = new ArrayDeque<>();
        floor(this.root, element, stack);
        return stack.size() > 0 ? stack.pop() : null;

    }

    private void floor(Node node, T element, Deque<T> stack) {
        if (node == null) {
            return;
        }

        floor(node.left, element, stack);

        int compare = node.value.compareTo(element);

        if (compare > 0 && stack.size() > 1 && stack.peek().compareTo(element) < 0) {
            return;
        }

        if (compare > 0) {
            return;
        }

        stack.push(node.value);
        floor(node.right, element, stack);
    }


    public void delete(T key) {
        if (this.count(this.root) == 0 || !this.contains(key)) {
            return;
        }

        this.root = this.delete(this.root, key);
    }

    private Node delete(Node node, T key) {
        if (node == null) {
            return null;
        }
        int compare = node.value.compareTo(key);
        if (compare > 0) {
            node.left = delete(node.left, key);
        } else if (compare < 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node leftMost = this.subtreeLeftMost(node.right);
            node.value = leftMost.value;
            node.right = this.delete(node.right, leftMost.value);
        }

        return node;
    }

    private Node subtreeLeftMost(Node node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }


    public int rank(T item) {
        return rank(this.root, item);
    }

    private int rank(Node node, T item) {
        if (node == null) {
            return 0;
        }

        int compare = node.value.compareTo(item);
        if (compare > 0) {
            return rank(node.left, item);
        } else if (compare < 0) {
            return 1 + this.count(node.left) + rank(node.right, item);
        }

        return this.count(node.left);

    }

    public T select(int n) {
        return select(this.root, n);
    }

    private T select(Node node, int n) {
        if (node == null) {
            return null;
        }

        int compare = Integer.compare(rank(node.value), n);

        if (compare > 0) {
            return select(node.left, n);
        } else if (compare < 0) {
            return select(node.right, n);
        }

        return node.value;
    }

    class Node {
        private T value;
        private Node left;
        private Node right;

        private int count;
        private int childrenCount;

        public Node(T value) {
            this.value = value;
            this.childrenCount = 1;
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

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return this.value + "";
        }
    }
}


