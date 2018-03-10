package organization;

import java.util.ArrayList;
import java.util.List;

public class Node<T extends Comparable<T>> {

    public T value;
    public Node<T> left;
    public Node<T> right;

    private List<T> equal;

    public int height;

    public Node(T value) {
        this.equal = new ArrayList<>();
        this.value = value;
        this.equal.add(value);
        this.height = 1;
    }

    public List<T> getEqual() {
        return equal;
    }

    public void setEqual(List<T> equal) {
        this.equal = equal;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
