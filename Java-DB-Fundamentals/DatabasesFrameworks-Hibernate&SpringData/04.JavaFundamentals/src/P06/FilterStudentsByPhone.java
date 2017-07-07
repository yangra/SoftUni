package P06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;


public class FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        Map<String, String> students = new LinkedHashMap<>();
        while (!"END".equals(line)) {
            String[] data = line.split("\\s");
            students.put(data[0] + " " + data[1], data[2]);
            line = reader.readLine();
        }

        students.entrySet().stream()
                .filter(s->s.getValue().startsWith("02")||s.getValue().startsWith("+3592"))
                .forEach(s-> System.out.println(s.getKey()));
    }
}
