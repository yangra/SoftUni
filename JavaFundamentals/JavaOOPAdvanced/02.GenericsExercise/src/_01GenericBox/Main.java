package _01GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfBoxes = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfBoxes; i++) {
            Box<String> stringBox = new Box<>(reader.readLine());
            System.out.println(stringBox);
        }
    }
}
