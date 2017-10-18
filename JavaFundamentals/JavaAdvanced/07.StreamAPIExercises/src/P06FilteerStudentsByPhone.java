import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class P06FilteerStudentsByPhone {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,String> students = new LinkedHashMap<>();
        while (true){
            String[] student = reader.readLine().split("\\s+");
            if("END".equalsIgnoreCase(student[0])){
                break;
            }

            students.put(student[0]+" "+student[1],student[2]);
        }

        students.entrySet().stream()
                .filter(me->me.getValue().startsWith("2")||me.getValue().startsWith("+3592"))
                .forEach(me->System.out.printf("%s %s\n", me.getKey(),me.getValue()));
    }
}
