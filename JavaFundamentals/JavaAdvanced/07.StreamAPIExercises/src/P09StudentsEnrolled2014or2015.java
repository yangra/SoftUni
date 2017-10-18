import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class P09StudentsEnrolled2014or2015 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> students = new LinkedHashMap<>();
        while (true) {
            String student = reader.readLine();
            if ("END".equalsIgnoreCase(student)) {
                break;
            }

            String studentNumber = student.substring(0,student.indexOf(' '));
            String marks = student.substring(student.indexOf(' ')+1);

            students.put(studentNumber,marks);
        }

        students.entrySet().stream()
                .filter(me->me.getKey().endsWith("14")|| me.getKey().endsWith("15"))
                .forEach(me->System.out.println(me.getValue()));

    }
}
