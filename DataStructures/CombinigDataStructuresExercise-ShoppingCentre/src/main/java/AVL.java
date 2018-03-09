import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class AVL<T extends Comparable<T>> {

    private Node<T> root;
    private int size;

    public Node<T> getRoot() {
        return this.root;
    }

    public int getSize() {
        return size;
    }

    public boolean contains(T item) {
        Node<T> node = this.search(this.root, item);
        return node != null;
    }

    public T search(T item){
        Node<T> node = this.search(this.root, item);
        return node == null? null: node.value;
    }

    public void insert(T item) {
        this.root = this.insert(this.root, item);
        this.size++;
    }

    public void eachInOrder(Consumer<T> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node<T> node, Consumer<T> action) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.left, action);
        if (node.getEqual().size() > 1) {
            for (int i = 0; i < node.getEqual().size(); i++) {
                action.accept(node.getEqual().get(i));
            }
        }else{
            action.accept(node.value);
        }
        this.eachInOrder(node.right, action);
    }

    private Node<T> insert(Node<T> node, T item) {
        if (node == null) {
            return new Node<>(item);
        }

        int cmp = item.compareTo(node.value);
        if (cmp < 0) {
            node.left = this.insert(node.left, item);
            this.updateHeight(node);
            node = this.balance(node);
        } else if (cmp > 0) {
            node.right = this.insert(node.right, item);
            this.updateHeight(node);
            node = this.balance(node);
        } else {
            node.getEqual().add(item);
        }

        return node;
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

    public void delete(T item) {
        this.root = delete(this.root, item);
        this.size--;
    }

    private Node<T> delete(Node<T> node, T item) {
        if (node == null) {
            return null;
        }

        int compare = item.compareTo(node.value);
        if (compare < 0) {
            node.left = delete(node.left, item);
        } else if (compare > 0) {
            node.right = delete(node.right, item);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            int balance = height(node.left) - height(node.right);
            if (balance > 0) {
                Node<T> nextNode = maxNode(node.left);
                node.value = nextNode.value;
                node.setEqual(nextNode.getEqual());
                node.left = delete(node.left, node.value);
            } else {
                Node<T> prevNode = minNode(node.right);
                node.value = prevNode.value;
                node.setEqual(prevNode.getEqual());
                node.right = delete(node.right, node.value);
            }

        }

        this.updateHeight(node);
        node = this.balance(node);

        return node;
    }

    private Node<T> maxNode(Node<T> node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }

        return node;
    }

    private Node<T> minNode(Node<T> node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    private T maxValue(Node<T> node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }

        return node.value;
    }


    public void deleteMin() {
        if (this.root == null) {
            return;
        }
        Node<T> min = minNode(this.root.left);
        if (min != null) {
            this.delete(min.value);
        } else {
            this.delete(root.value);
        }
        this.size--;
    }

    // BONUS
    public void deleteMax() {
        if (this.root == null) {
            return;
        }
        Node<T> max = maxNode(this.root.right);
        if (max != null) {
            this.delete(max.value);
        } else {
            this.delete(root.value);
        }
        this.size--;
    }

    private Node<T> balance(Node<T> node) {
        int balance = height(node.left) - height(node.right);
        if (balance > 1) {
            int childBalance = height(node.left.left) - height(node.left.right);
            if (childBalance < 0) {
                node.left = RotateLeft(node.left);
            }

            node = RotateRight(node);
        } else if (balance < -1) {
            int childBalance = height(node.right.left) - height(node.right.right);
            if (childBalance > 0) {
                node.right = RotateRight(node.right);
            }

            node = RotateLeft(node);
        }

        return node;
    }

    private Node<T> RotateRight(Node<T> node) {
        Node<T> left = node.left;
        node.left = left.right;
        left.right = node;

        updateHeight(node);
        left.height = Math.max(this.height(node), this.height(left.left)) + 1;

        return left;
    }

    private Node<T> RotateLeft(Node<T> node) {
        Node<T> right = node.right;
        node.right = right.left;
        right.left = node;

        updateHeight(node);
        right.height = Math.max(this.height(node), this.height(right.right)) + 1;

        return right;
    }

    private void updateHeight(Node<T> node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    public Iterable<T> max(int count) {
        List<T> maxCount = new ArrayList<>();
        maxRecursive(this.root, maxCount, count);
        return maxCount;
    }

    private void maxRecursive(Node<T> node, List<T> maxCount, int count) {
        if (node == null) {
            return;
        }

        maxRecursive(node.right, maxCount, count);
        if (maxCount.size() < count) {
            if(node.getEqual().size()>1){
                int counter = 0;
                while(maxCount.size() < count && counter<node.getEqual().size()){
                    maxCount.add(node.getEqual().get(counter));
                    counter++;
                }
            }else{
                maxCount.add(node.value);
            }

        }
        maxRecursive(node.left, maxCount, count);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        this.eachInOrder(builder::append);
        return builder.toString();
    }
}
