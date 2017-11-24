package _08CustomListSorter;

import java.util.ArrayList;
import java.util.List;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T> {
    private List<T> list;

    public CustomListImpl() {
        this.list = new ArrayList<>();
    }

    public int size(){return this.list.size(); }
    @Override
    public void add(T element) {
        this.list.add(element);
    }

    @Override
    public T remove(int index) {
        return this.list.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.list.contains(element);
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        if (this.list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        if (firstIndex < 0 || firstIndex >= list.size() || secondIndex < 0 || secondIndex >= list.size()) {
            throw new IllegalArgumentException("Index out of bounds of the list");
        }

        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }

    @Override
    public int countGreaterThan(T element) {
        int count = 0;
        for (T t : list) {
            if (element.compareTo(t) < 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public T getMax() {
        T max = list.get(0);
        for (T t : list) {
            if (t.compareTo(max) > 0) {
                max = t;
            }
        }
        return max;
    }

    @Override
    public T getMin() {
        T min = list.get(0);
        for (T t : list) {
            if (t.compareTo(min) < 0) {
                min = t;
            }
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.list.forEach(e -> sb.append(e).append(System.lineSeparator()));
        return sb.toString();
    }
}
