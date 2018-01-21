package _05LinkedQueue;

public class LinkedQueue<E> {

    private QueueNode head;
    private QueueNode tail;
    private int size;

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(E element) {
        QueueNode qNode = new QueueNode(element);
        if(this.size == 0){
            this.head = qNode;
            this.tail = qNode;
        }else{
            this.tail.nextNode = qNode;
            this.tail = qNode;
        }

        this.size++;
    }

    public E dequeue() {
        if(this.size == 0){
            throw new IllegalArgumentException();
        }

        E element = (E)this.head.value;
        this.head = this.head.nextNode;
        this.head.prevNode = null;
        this.size--;
        return element;
    }

    public E[] toArray(){
        E[] arr = (E[]) new Object[this.size];
        QueueNode next = this.head;
        for (int i = 0; i < this.size; i++) {
            arr[i] = (E) next.value;
            next = next.nextNode;
        }

        return arr;
    }

    private class QueueNode<E> {
        private E value;
        private QueueNode<E> nextNode;
        private QueueNode<E> prevNode;

        public QueueNode(E value) {
            this.value = value;
        }
    }

}
