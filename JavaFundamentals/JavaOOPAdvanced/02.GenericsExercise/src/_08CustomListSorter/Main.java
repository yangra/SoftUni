package _08CustomListSorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> myList = new CustomListImpl<>();
        while(true){
            String[] command = reader.readLine().split("\\s+");
            if("END".equalsIgnoreCase(command[0])){
                break;
            }

            switch (command[0].toLowerCase()){
                case "add":
                    myList.add(command[1]);
                    break;
                case "remove":
                    myList.remove(Integer.parseInt(command[1]));
                    break;
                case "contains":
                    System.out.println(myList.contains(command[1]));
                    break;
                case "swap":
                    myList.swap(Integer.parseInt(command[1]),Integer.parseInt(command[2]));
                    break;
                case "greater":
                    System.out.println(myList.countGreaterThan(command[1]));
                    break;
                case "max":
                    System.out.println(myList.getMax());
                    break;
                case "min":
                    System.out.println(myList.getMin());
                    break;
                case "sort":
                    Sorter.sort(myList);
                    break;
                case "print":
                    System.out.println(myList.toString().trim());
                    break;

            }
        }
    }
}
