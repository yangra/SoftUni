package _06StrategyPattern;

import javafx.print.Collation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> peopleComparedByName = new TreeSet<>(new NameComparator());
        Set<Person> peopleComparedByAge = new TreeSet<>(new AgeComparator());

        int numberOfPeople = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = reader.readLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            peopleComparedByName.add(person);
            peopleComparedByAge.add(person);
        }

        for (Person person : peopleComparedByName) {
            System.out.println(person);
        }

        for (Person person : peopleComparedByAge) {
            System.out.println(person);
        }
    }
}
