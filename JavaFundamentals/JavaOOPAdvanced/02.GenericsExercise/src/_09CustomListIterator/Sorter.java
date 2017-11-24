package _09CustomListIterator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        List<T> extracted = new ArrayList<>();

        while (list.size()>0){
            extracted.add(list.remove(0));
        }

        Collections.sort(extracted);
        for (T t : extracted) {
            list.add(t);
        }
    }
}
