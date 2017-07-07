package P03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        List<String> students = new ArrayList<>();
        while (!"END".equals(line)) {
            students.add(line.trim());
            line = reader.readLine();
        }

        students.stream()
                .filter(s->Integer.parseInt(s.substring(s.lastIndexOf(" ")+1))>=18&&Integer.parseInt(s.substring(s.lastIndexOf(" ")+1))<=24)
                .forEach(System.out::println);
    }

}
