import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01StudentsByGroup {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> students = new ArrayList<>();
        while (true) {
            String student = reader.readLine();
            if ("END".equalsIgnoreCase(student)) {
                break;
            }
            students.add(student);
        }

        students.stream()
                .filter(s -> Integer.valueOf(s.split("\\s+")[2]) == 2)
                .sorted(Comparator.comparing(s -> s.split("\\s+")[0]))
                .forEach(s -> System.out.println(s.split("\\s+")[0] + " " + s.split("\\s+")[1]));
    }
}
