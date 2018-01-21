package _03ArrayStack;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<T> implements Iterable<T> {
    private static final int INITIAL_CAPACITY = 16;

    private T[] elements;
    private int size;

    public ArrayStack() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public ArrayStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void push(T element) {
        if (this.size == this.elements.length) {
            this.grow();
        }

        this.elements[this.size] = element;
        this.size++;
    }

    public T pop() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        T element = this.elements[this.size-1];
        this.elements[this.size-1] = null;
        this.size--;
        return element;
    }

    public T[] toArray() {

        T[] result = (T[]) new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            result[i] = this.elements[this.size-i-1];

        }

        return result;
    }

    private void grow() {
        T[] newArr = Arrays.copyOf(this.elements, this.elements.length * 2);
        this.elements = newArr;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayStackIterator();
    }

    private final class ArrayStackIterator implements Iterator<T>{

        int index = size-1;
        @Override
        public boolean hasNext() {
            return index>=0;
        }

        @Override
        public T next() {
            return elements[index--];
        }
    }
}
