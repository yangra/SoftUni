package main.bg.softuni.dataStructures.contracts;

import java.util.Collection;

public interface SimpleOrderedBag<T extends Comparable<T>> extends Iterable<T> {

    void add(T element);

    void addAll(Collection<T> elements);

    int size();

    String joinWith(String delimiter);

    boolean remove(T element);

    int capacity();
}
