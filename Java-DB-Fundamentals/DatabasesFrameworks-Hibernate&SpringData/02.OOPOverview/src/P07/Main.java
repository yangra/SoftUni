package P07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yana on 7/1/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfStudents = Integer.parseInt(reader.readLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i <  numberOfStudents ; i++) {
            String[] data = reader.readLine().split("\\s");
            String name = data[0];
            List<Double> grades = new ArrayList<>();
            for (int j = 1; j < data.length; j++) {
                grades.add(Double.parseDouble(data[j]));
            }
            Student student = new Student(name, grades);
            students.add(student);
        }

        students.stream().filter(a->a.getAverageGrade()>=5.00).sorted((a,b) ->{
                int result = a.getName().compareTo(b.getName());
                if(result == 0){
                    result = Double.compare(b.getAverageGrade(), a.getAverageGrade());
                }
                return result;
        }).forEach(a-> System.out.printf("%s -> %.2f\n", a.getName(),a.getAverageGrade()));
    }
}
