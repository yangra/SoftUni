package _09LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();

        int numberOfCommands = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = reader.readLine().split("\\s+");
            switch(command[0]){
                case "Add":
                    linkedList.add(Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    linkedList.remove(Integer.parseInt(command[1]));
                    break;
            }
        }

        System.out.println(linkedList.getSize());
        for (Integer integer : linkedList) {
            System.out.print(integer + " ");
        }
    }
}
