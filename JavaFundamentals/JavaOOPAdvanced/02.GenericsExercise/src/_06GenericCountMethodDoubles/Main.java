package _06GenericCountMethodDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Box<Double>> boxes = new ArrayList<>();
        int numberOfBoxes = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfBoxes; i++) {
            Box<Double> doubleBox = new Box<>(Double.parseDouble(reader.readLine()));
            boxes.add(doubleBox);
        }
        Double value = Double.parseDouble(reader.readLine());
        Box<Double> box = new Box<>(value);
        System.out.println(countGreater(boxes, box));
    }

    private static <T extends Comparable<T>> int countGreater(List<T> list, T element){
        int count = 0;
        for (T t : list) {
            if( element.compareTo(t)<0){
                count++;
            }
        }
        return count;
    }


    private static <T> void swap(List<T> list, int firstIndex, int secondIndex) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        if (firstIndex < 0 || firstIndex >= list.size() || secondIndex < 0 || secondIndex >= list.size()) {
            throw new IllegalArgumentException("Index out of bounds of the list");
        }

        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }
}
