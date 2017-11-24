package _07CustomList;

import java.util.ArrayList;
import java.util.List;

public class GenericList<T extends Comparable<T>> {
    private List<T> list;

    public GenericList() {
        this.list = new ArrayList<>();
    }

    void add(T element) {
        this.list.add(element);
    }

    T remove(int index) {
        return this.list.remove(index);
    }

    boolean contains(T element) {
        return this.list.contains(element);
    }

    void swap(int firstIndex, int secondIndex) {
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

    int countGreaterThan(T element) {
        int count = 0;
        for (T t : list) {
            if (element.compareTo(t) < 0) {
                count++;
            }
        }
        return count;
    }

    T getMax() {
        T max = list.get(0);
        for (T t : list) {
           if(t.compareTo(max)>0) {
               max = t;
           }
        }
        return max;
    }

    T getMin() {
        T min = list.get(0);
        for (T t : list) {
            if(t.compareTo(min)<0) {
                min = t;
            }
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.list.forEach(e->sb.append(e).append(System.lineSeparator()));
        return sb.toString();
    }
}
