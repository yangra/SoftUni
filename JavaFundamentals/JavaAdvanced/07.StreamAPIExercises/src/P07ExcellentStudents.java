import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P07ExcellentStudents {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> students = new LinkedHashMap<>();
        while (true) {
            String[] student = reader.readLine().split("\\s+");
            if ("END".equalsIgnoreCase(student[0])) {
                break;
            }

            String studentName = student[0] + " " + student[1];
            List<Integer> marks = new ArrayList<>();
            for (int i = 2; i < student.length; i++) {
                Integer mark = Integer.parseInt(student[i]);
                marks.add(mark);
            }

            students.put(studentName,marks);
        }

        students.entrySet().stream()
                .filter(me->me.getValue().contains(6))
                .forEach(me->System.out.printf("%s %s\n",me.getKey(),
                        me.getValue().stream()
                                .sorted((a,b)->b.compareTo(a))
                                .collect(Collectors.toList())
                                .toString()
                                .replaceAll("[\\[\\],]","")));
    }
}
