package _04ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        Collections.addAll(myList, 1,2,3,4,5);

        System.out.println(ListUtils.getMin(myList));
        System.out.println(ListUtils.getMax(myList));

        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1,2,null,3,null);

        System.out.println(ListUtils.getNullIndices(integers));

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a",null,"c");

        System.out.println(ListUtils.getNullIndices(strings));

        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints,1,2,4,5);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles,1.2,4.5);

        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged, ints, doubles);

        List<Number> dest = new ArrayList<>();
        ListUtils.flatten(dest, jagged);
        System.out.println(dest);

        List<Number> destination = new ArrayList<>();

        ListUtils.addAll(destination,ints);
        ListUtils.addAll(destination,doubles);
        System.out.println(destination);
    }
}
