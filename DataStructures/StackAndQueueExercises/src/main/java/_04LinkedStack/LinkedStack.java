package _04LinkedStack;

public class LinkedStack<E> {
    private Node<E> firstNode;
    private int size;

    public LinkedStack() {
        this.firstNode = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void push(E element){
        Node newNode = new Node(element);
        newNode.next = this.firstNode;
        this.firstNode = newNode;
        this.size++;
    }

    public E pop(){
        if(this.size==0){
            throw new IllegalArgumentException();
        }

        E element = this.firstNode.value;
        this.firstNode = this.firstNode.next;
        this.size--;
        return element;
    }

    public E[] toArray(){
        E[] arr = (E[]) new Object[this.size];
        Node next = this.firstNode;
        for (int i = 0; i < this.size; i++) {
            arr[i] = (E)next.value;
            next = next.next;
        }
        return arr;
    }

    private class Node<E>{
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
        }
    }
}
