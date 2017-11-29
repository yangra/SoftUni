package _03StackIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyStackImpl<T> implements MyStack<T>, Iterable<T> {
    private List<T> elements;

    public MyStackImpl() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void push(T... elements) {
        this.elements.addAll(new ArrayList<>(Arrays.asList(elements)));
    }

    @Override
    public T pop() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("No elements");
        }

        return this.elements.remove(this.elements.size() - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<T> {

        private int index;

        public StackIterator() {
            this.index = elements.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return this.index >= 0;
        }

        @Override
        public T next() {
            return elements.get(index--);
        }
    }
}
