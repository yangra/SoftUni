package _09CollectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        AddCollection addList = new AddCollectionImpl();
        AddRemoveCollection addRemoveList = new AddRemoveCollectionImpl();
        MyList list = new MyListImpl();

        String[] input = reader.readLine().split("\\s+");
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        for (String s : input) {
            sb1.append(addList.add(s)).append(" ");
            sb2.append(addRemoveList.add(s)).append(" ");
            sb3.append(list.add(s)).append(" ");
        }

        System.out.println(sb1.toString().trim());
        System.out.println(sb2.toString().trim());
        System.out.println(sb3.toString().trim());

        sb1.setLength(0);
        sb2.setLength(0);

        int numberOfRemoves = Integer.parseInt(reader.readLine());

        for (int i = 0; i< numberOfRemoves; i++) {
            sb1.append(addRemoveList.remove()).append(" ");
            sb2.append(list.remove()).append(" ");
        }

        System.out.println(sb1.toString().trim());
        System.out.println(sb2.toString().trim());

    }
}
