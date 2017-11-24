package _03GenericSwapMetodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Box<String>> boxes = new ArrayList<>();
        int numberOfBoxes = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfBoxes; i++) {
            Box<String> stringBox = new Box<>(reader.readLine());
            boxes.add(stringBox);
        }
        String[] indices = reader.readLine().split("\\s+");
        swap(boxes, Integer.parseInt(indices[0]), Integer.parseInt(indices[1]));
        boxes.forEach(System.out::println);


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
