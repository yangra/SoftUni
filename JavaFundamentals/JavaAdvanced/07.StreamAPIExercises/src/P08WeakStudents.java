import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P08WeakStudents {
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
                .filter(me->me.getValue().stream().filter(m->m<=3.0).count()>=2)
                .sorted(Comparator.comparing(me->me.getValue().stream().reduce((x,y)->x+y).get()))
                .forEach(me->System.out.printf("%s %s\n",me.getKey(),
                        me.getValue().stream().sorted((a,b)->a.compareTo(b))
                                .collect(Collectors.toList())
                                .toString()
                                .replaceAll("[\\[\\],]","")));
    }
}
