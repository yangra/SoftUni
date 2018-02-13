import java.util.function.Consumer;

public class AVL<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> getRoot() {
        return this.root;
    }

    public boolean contains(T item) {
        Node<T> node = this.search(this.root, item);
        return node != null;
    }

    public void insert(T item) {
        this.root = this.insert(this.root, item);
    }

    public void eachInOrder(Consumer<T> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node<T> node, Consumer<T> action) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.left, action);
        action.accept(node.value);
        this.eachInOrder(node.right, action);
    }

    private Node<T> insert(Node<T> node, T item) {
        if (node == null) {
            return new Node<>(item);
        }

        int cmp = item.compareTo(node.value);
        if (cmp < 0) {
            node.left = this.insert(node.left, item);
            node.height = Math.max(this.height(node.left), this.height(node.right)) + 1;
        } else if (cmp > 0) {
            node.right = this.insert(node.right, item);
            node.height = Math.max(this.height(node.left), this.height(node.right)) + 1;
        }

        // balance tree
        int balance = this.height(node.left) - this.height(node.right);
        if (balance > 1) {
            int childBalance = this.height(node.left.left) - this.height(node.left.right);
            if (childBalance < 0) {
                node.left = this.rotateLeft(node.left);
            }
            node = this.rotateRight(node);
        } else if (balance < -1) {
            int childBalance = this.height(node.right.left) - this.height(node.right.right);
            if (childBalance > 0) {
                node.right = this.rotateRight(node.right);
            }
            node = this.rotateLeft(node);
        }

        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> temp = node.left;
        node.left = node.left.right;
        temp.right = node;
        node.height = Math.max(this.height(node.left), this.height(node.right)) + 1;
        temp.height = Math.max(this.height(node), this.height(temp.left)) + 1;
        return temp;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> temp = node.right;
        node.right = node.right.left;
        temp.left = node;
        node.height = Math.max(this.height(node.left), this.height(node.right)) + 1;
        temp.height = Math.max(this.height(node), this.height(temp.right)) + 1;
        return temp;
    }

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    private Node<T> search(Node<T> node, T item) {
        if (node == null) {
            return null;
        }

        int cmp = item.compareTo(node.value);
        if (cmp < 0) {
            return search(node.left, item);
        } else if (cmp > 0) {
            return search(node.right, item);
        }

        return node;
    }
}
