package _05ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if ("END".equalsIgnoreCase(input[0])) {
                break;
            }
            Person person = new Person(input[0], Integer.parseInt(input[1]), input[2]);
            people.add(person);
        }

        int index = Integer.parseInt(reader.readLine());
        Person person = people.get(index - 1);
        int equal = 0;
        for (Person per : people) {
            if (per.compareTo(person) == 0) {
                equal++;
            }
        }
        if (equal == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d\n", equal, people.size() - equal, people.size());
        }
    }
}
