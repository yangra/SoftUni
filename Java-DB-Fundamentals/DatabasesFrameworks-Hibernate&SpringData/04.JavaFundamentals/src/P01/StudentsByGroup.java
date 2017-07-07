package P01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        List<String> students = new ArrayList<>();
        while (!"END".equals(line)) {
            students.add(line.trim());
            line = reader.readLine();
        }

        students.stream()
                .filter(s -> s.endsWith("2"))
                .sorted((a,b)->a.substring(0,a.indexOf(" ")-1).compareTo(b.substring(0,b.indexOf(" ")-1)))
                .forEach(s -> System.out.println(s.substring(0,s.length()-2)));
    }
}
