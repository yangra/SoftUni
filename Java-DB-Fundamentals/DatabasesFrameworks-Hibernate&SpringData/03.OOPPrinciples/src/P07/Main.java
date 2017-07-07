package P07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info1 = reader.readLine().split("\\s");
        String[] info2 = reader.readLine().split("\\s");
        String studentFirstName = info1[0];
        String studentLastName = info1[1];
        String studentFacultyNum = info1[2];
        String workerFirstName = info2[0];
        String workerLastName = info2[1];
        double workerWeekSalary = Double.parseDouble(info2[2]);
        double workerWorkHoursPerDay = Double.parseDouble(info2[3]);
        try{
            Student student = new Student(studentFirstName,studentLastName,studentFacultyNum);
            Worker worker = new Worker(workerFirstName,workerLastName,workerWeekSalary,workerWorkHoursPerDay);
            System.out.println(student.toString());
            System.out.println(worker.toString());
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
