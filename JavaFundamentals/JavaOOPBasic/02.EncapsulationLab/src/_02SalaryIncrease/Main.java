package _02SalaryIncrease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);

        List<Person> people = new ArrayList<>();

        int numberOfPeople = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = reader.readLine().split("\\s+");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2]),Double.parseDouble(input[3])));
        }

        double bonus = Double.parseDouble(reader.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }

}
