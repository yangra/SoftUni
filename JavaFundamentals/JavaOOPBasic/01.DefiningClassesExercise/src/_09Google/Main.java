package _09Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new HashMap<>();
        while (true) {
            String[] record = reader.readLine().split("\\s+");
            if ("End".equalsIgnoreCase(record[0])) {
                break;
            }

            people.putIfAbsent(record[0], new Person(record[0]));
            Person person = people.get(record[0]);
            switch (record[1]) {
                case "company":
                    Person.Company company =  person.new Company(record[2],record[3],Double.parseDouble(record[4]));
                    person.setCompany(company);
                    break;
                case "pokemon":
                    Person.Pokemon pokemon = person.new Pokemon(record[2],record[3]);
                    person.getPokemons().add(pokemon);
                    break;
                case "parents":
                    Person.Human parent = person.new Human(record[2], record[3]);
                    person.getParents().add(parent);
                    break;
                case "children":
                    Person.Human child = person.new Human(record[2],record[3]);
                    person.getChildren().add(child);
                    break;
                case "car":
                    Person.Car car = person.new Car(record[2], Integer.parseInt(record[3]));
                    person.setCar(car);
                    break;
                default:
                    System.out.println("Invalid record!");
                    break;
            }
        }

        String personName = reader.readLine();
        System.out.println(people.get(personName));
    }
}
