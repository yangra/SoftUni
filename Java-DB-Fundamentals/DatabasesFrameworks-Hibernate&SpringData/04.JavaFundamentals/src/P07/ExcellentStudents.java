package P07;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> students = new LinkedHashMap<>();
        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] data = line.split("\\s");
            String name = data[0] + " " + data[1];
            List<Integer> grades = new ArrayList<>();
            for (int i = 2; i < data.length; i++) {
               grades.add(Integer.parseInt(data[i]));
            }
            students.put(name,grades);
            line = reader.readLine();
        }

        students
                .entrySet()
                .stream()
                .filter(s->s.getValue().contains(6))
                .forEach(s-> System.out.println(s.getKey()));
    }
}
