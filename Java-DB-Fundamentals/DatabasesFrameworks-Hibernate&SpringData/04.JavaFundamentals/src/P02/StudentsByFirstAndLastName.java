package P02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        List<String> students = new ArrayList<>();
        while (!"END".equals(line.trim())) {
            students.add(line.trim());
            line = reader.readLine();
        }

        students.stream()
                .filter(s->s.substring(0,s.indexOf(" ")).compareTo(s.substring(s.indexOf(" ")+1))<0)
                .forEach(System.out::println);
    }
}
