package _01ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] createCommand = reader.readLine().split("\\s+");
        ListyIterator list = new ListyIteratorImpl(Arrays.stream(createCommand).skip(1).toArray(String[]::new));

        while (true) {
            String[] command = reader.readLine().split("\\s+");
            if ("END".equalsIgnoreCase(command[0])) {
                break;
            }

            switch (command[0]) {
                case "HasNext":
                    System.out.println(list.hasNext());
                    break;
                case "Move":
                    System.out.println(list.move());
                    break;
                case "Print":
                    try {
                        list.print();
                    } catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }
                    break;

            }
        }
    }
}
