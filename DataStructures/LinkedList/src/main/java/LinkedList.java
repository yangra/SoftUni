import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E item) {
        Node newNode = new Node(item);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(E item) {
        Node newNode = new Node(item);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public E removeFirst() {
        if (this.size == 0) {
            throw new UnsupportedOperationException();
        }
        E element = this.head.value;
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }else{
            this.head = this.head.next;
        }
        this.size--;
        return element;
    }

    public E removeLast() {
        if (this.size == 0) {
            throw new UnsupportedOperationException();
        }
        E element = this.tail.value;
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }else{
            Node nextNode = this.head;
            while (!nextNode.next.equals(this.tail)) {
                nextNode = nextNode.next;
            }
            nextNode.next = null;
            this.tail = nextNode;

        }
        this.size--;
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private final class LinkedListIterator implements Iterator<E> {

        private Node index;

        public LinkedListIterator() {
            this.index = head;
        }

        @Override
        public boolean hasNext() {
            return this.index != tail;
        }

        @Override
        public E next() {
            E element = this.index.value;
            this.index = this.index.next;
            return element;
        }
    }

    private class Node {
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
        }
    }

}
