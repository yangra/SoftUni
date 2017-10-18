import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P10GroupByGroup {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> students = new ArrayList<>();
        while(true){
            String[] student = reader.readLine().split(" ");
            if("END".equalsIgnoreCase(student[0])){
                break;
            }

            students.add(new Person(student[0]+" "+student[1],Integer.parseInt(student[2])));
        }

        students.stream()
                .collect(Collectors.groupingBy(Person::getGroup)).entrySet()
                .forEach(me-> System.out.printf("%d - %s\n", me.getKey(),me.getValue().stream()
                        .map(v->String.format("%s",v.getName()))
                        .collect(Collectors.joining(", "))));
    }

    static class Person{
        private String name;
        private Integer group;

        public Person(String name, Integer group) {
            this.name = name;
            this.group = group;
        }

        public String getName() {
            return name;
        }

        public Integer getGroup() {
            return group;
        }
    }
}
