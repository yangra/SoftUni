package P09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class StudentsEnrolledIn2014Or2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,List<String>> students = new LinkedHashMap<>();
        String line = reader.readLine();
        while(true){
            if("END".equals(line)){
                break;
            }
            String[] data = line.split("\\s");
            String facultyNum = data[0];
            List<String> grades = new ArrayList<>();
            for (int i = 1; i < data.length ; i++) {
                grades.add(data[i]);
            }
            students.put(facultyNum,grades);
            line = reader.readLine();
        }

        students.entrySet().stream().filter(s->s.getKey().endsWith("14")|| s.getKey().endsWith("15"))
                .forEach(s-> System.out.println(String.join(" ", s.getValue())));
    }
}
