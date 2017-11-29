package _01ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIteratorImpl<T> implements ListyIterator<T> {
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
    public boolean move() {
        if (this.index >= this.elements.size() - 1) {
            return false;
        }
        return ++index < elements.size();
    }
}
