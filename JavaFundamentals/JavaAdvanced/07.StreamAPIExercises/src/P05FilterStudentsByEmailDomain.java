import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P05FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> students = new ArrayList<>();
        while (true){
            String student = reader.readLine();
            if("END".equalsIgnoreCase(student)){
                break;
            }

            students.add(student);
        }

        students.stream()
                .filter(s->s.split("\\s+")[2].contains("@gmail.com"))
                .map(s->s.split("\\s+")[0]+" "+s.split("\\s+")[1])
                .forEach(System.out::println);
    }
}
