package _06ReversedList;

import java.util.Arrays;
import java.util.Iterator;

public class ReversedList<E> implements Iterable<E> {

    private E[] arr;
    private int count;
    private int capacity;

    public ReversedList() {
        this.count = 0;
        this.capacity = 2;
        this.arr = (E[]) new Object[this.capacity];
    }

    public int count() {
        return this.count;
    }

    private void setCount(int count) {
        this.count = count;
    }

    public int capacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public E get(int index) {
        E element = this.arr[this.count - index - 1];
        return element;
    }

    public void set(int index, E element) {
        this.arr[this.count-index-1] = element;
    }

    public void add(E item) {
        if (this.count == this.capacity) {
            this.resize();
        }

        this.arr[this.count] = item;
        this.count++;
    }

    public void removeAt(int index) {
        for (int i = this.count - index - 1; i < this.arr.length-1; i++) {
            this.arr[i] = this.arr[i+1];
        }
        this.arr[this.arr.length-1] = null;
        this.count--;
    }

    private void resize() {
        E[] newArr = Arrays.copyOf(this.arr, this.capacity * 2);
        this.arr = newArr;
        this.capacity *= 2;
    }

    @Override
    public Iterator<E> iterator() {
        return new ReversedListIterator();
    }

    private final class ReversedListIterator implements Iterator<E> {

        int index = count-1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public E next() {
            return arr[index--];
        }
    }
}
