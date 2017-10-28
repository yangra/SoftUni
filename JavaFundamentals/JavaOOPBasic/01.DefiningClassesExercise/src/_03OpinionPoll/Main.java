package _03OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPeople = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            String[] params = reader.readLine().split("\\s+");
            Person person = new Person(params[0],Integer.parseInt(params[1]));
            people.add(person);
        }

        people.stream().filter(p->p.getAge()>30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p-> System.out.printf("%s - %d\n", p.getName(),p.getAge()));
    }
}
