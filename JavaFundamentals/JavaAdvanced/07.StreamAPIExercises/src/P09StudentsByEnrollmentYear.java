import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P09StudentsByEnrollmentYear {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> students = new HashMap<>();
        while (true) {
            String[] student = reader.readLine().split("\\s+");
            if ("END".equalsIgnoreCase(student[0])) {
                break;
            }

            String year = "20" + student[0].substring(student[0].length() - 2);
            String name = student[1] + " " + student[2];

            students.putIfAbsent(year, new ArrayList<>());
            students.get(year).add(name);
        }

        students.entrySet().stream()
                .sorted(Comparator.comparing(me->me.getKey()))
                .forEach(me->System.out.printf("%s:\n%s\n",me.getKey(),
                        me.getValue().stream()
                                .map(s->"--"+s)
                                .sorted((a,b)->a.compareTo(b))
                                .collect(Collectors.toList()).toString()
                                .replaceAll("[\\]\\[]","")
                                .replaceAll("\\s*--","-- ")
                                .replaceAll("[,]","\r\n")));
    }

}
