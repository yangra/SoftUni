package _08DoublyLinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedList<E> implements Iterable<E> {

    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E element) {
        Node newNode = new Node(element);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(E element) {
        Node newNode = new Node(element);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    public E removeFirst() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        E element = this.head.value;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
        return element;
    }

    public E removeLast() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        E element = this.tail.value;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return element;
    }

    public E[] toArray() {
        E[] arr = (E[]) new Object[this.size];
        Node next = this.head;
        for (int i = 0; i < this.size; i++) {
            arr[i] = next.value;
            next = next.next;
        }

        return arr;
    }

    @Override
    public Iterator<E> iterator() {
        return new DoublyListIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterator<E> iterator = this.iterator();
        while (iterator.hasNext()) {
            action.accept(iterator.next());
        }
    }

    private final class DoublyListIterator implements Iterator<E> {

        Node index = head;

        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public E next() {
            E value = index.value;
            index = index.next;
            return value;
        }
    }

    private class Node {
        private E value;
        private Node prev;
        private Node next;

        public Node(E value) {
            this.value = value;
        }
    }

}
