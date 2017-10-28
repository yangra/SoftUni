package _10FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> relations = new ArrayList<>();
        List<Person> people = new ArrayList<>();

        String query = reader.readLine();

        while (true) {
            String input = reader.readLine();
            if ("End".equals(input)) {
                break;
            }

            if (input.contains("-")) {
                relations.add(input);
            } else {
                String[] params = input.split("\\s+");
                String name = params[0] + " " + params[1];
                String date = params[2];

                Person person = new Person();
                person.setName(name);
                person.setBirthDate(date);
                people.add(person);
            }
        }

        Person you = null;
        if (people.stream().filter(p -> query.equals(p.getName())).count() > 0) {
            you = people.stream()
                    .filter(p -> query.equals(p.getName())).findFirst().get();
        }
        if (people.stream().filter(p -> query.equals(p.getBirthDate())).count() > 0) {
            you = people.stream()
                    .filter(p -> query.equals(p.getBirthDate())).findFirst().get();
        }

        for (String relation : relations) {
            String[] relatives = relation.split("\\s+-\\s+");
            Person parent = null;
            if(relatives[0].contains("/")){
                parent = people.stream().filter(p->p.getBirthDate().equals(relatives[0])).findFirst().get();
            }else{
                parent = people.stream().filter(p->p.getName().equals(relatives[0])).findFirst().get();
            }

            Person child = null;
            if(relatives[1].contains("/")){
                child = people.stream().filter(p->p.getBirthDate().equals(relatives[1])).findFirst().get();
            }else{
                child = people.stream().filter(p->p.getName().equals(relatives[1])).findFirst().get();
            }

            parent.addChild(child);
            child.addParent(parent);
        }

        System.out.println(you);
        System.out.println("Parents:");
        you.getParents().forEach(System.out::println);
        System.out.println("Children:");
        you.getChildren().forEach(System.out::println);

    }
}
