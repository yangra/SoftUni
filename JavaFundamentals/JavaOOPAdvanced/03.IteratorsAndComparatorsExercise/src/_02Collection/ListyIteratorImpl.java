package _02Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListyIteratorImpl<T> implements ListyIterator<T>,Iterable<T> {
    private List<T> elements;
    private int index;

    public ListyIteratorImpl(T... elements) {
        this.elements = new ArrayList<>(Arrays.asList(elements));
        this.index = 0;
    }


    @Override
    public boolean hasNext() {
        return this.index < elements.size() - 1;
    }

    @Override
    public void print() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(elements.get(this.index));
    }

    @Override
    public void printAll() {
        StringBuilder sb = new StringBuilder();
        elements.forEach(e -> sb.append(e).append(" "));
        System.out.println(sb.toString().trim());
    }

    @Override
    public boolean move() {
        if (this.index >= this.elements.size() - 1) {
            return false;
        }
        return ++index < elements.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private final class ListIterator implements Iterator<T> {

        private int counter;

        public ListIterator() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return this.counter < elements.size() - 1;
        }

        @Override
        public T next() {
            return elements.get(counter++);
        }
    }
}
