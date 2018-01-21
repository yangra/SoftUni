import java.util.Iterator;

@SuppressWarnings("unchecked")
public class CircularQueue<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 4;

    private E[] arr;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularQueue() {
        this.setCapacity(DEFAULT_CAPACITY);
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.arr = (E[]) new Object[this.capacity()];
    }

    public CircularQueue(int initialCapacity) {
        this.setCapacity(initialCapacity);
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.arr = (E[]) new Object[this.capacity()];
    }

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public int capacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(E element) {
        if ((this.size ) >= this.capacity) {
            this.resize();
        }
        arr[this.tail] = element;
        this.tail = (this.tail + 1) % this.capacity;
        this.size++;
    }

    public E dequeue() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        E element = arr[this.head];
        this.head = (this.head + 1) % this.capacity;
        this.size--;
        return element;
    }

    public E[] toArray() {
        E[] newArr = (E[]) new Object[this.size];
        this.copyAllElements(newArr);
        return newArr;
    }

    private void resize() {
        E[] newArr = (E[]) new Object[this.capacity*2];
        this.copyAllElements(newArr);
        this.arr = newArr;
        this.capacity *= 2;
        this.head = 0;
        this.tail = this.size;
    }

    private void copyAllElements(E[] newArr) {
        Iterator<E> iterator = this.iterator();
        for (int i = 0; i < this.size; i++) {
            newArr[i] = iterator.next();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new CircularQueueIterator();
    }

    private final class CircularQueueIterator implements Iterator<E> {

        private int index;

        public CircularQueueIterator() {
            this.index = head;
        }

        @Override
        public boolean hasNext() {
            return index != tail;
        }

        @Override
        public E next() {
            return arr[(index++) % capacity];
        }
    }
}
