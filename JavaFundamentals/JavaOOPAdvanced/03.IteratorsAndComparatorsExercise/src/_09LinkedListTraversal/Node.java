package _09LinkedListTraversal;

public class Node<T> {
    private Node previous;

    public Node getPrevious() {
        return this.previous;
    }

    private Node next;
    private T data;

    void setPrevious(Node previous) {
        this.previous = previous;
    }

    Node(T data) {
        this.data = data;
    }

    Node getNext() {
        return this.next;
    }

    T getData() {
        return this.data;
    }

    void setNext(Node next) {
        this.next = next;
    }
}
