package _03Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] studentData = reader.readLine().split("\\s+");
            Student student = new Student(studentData[0], studentData[1], studentData[2]);
            System.out.println(student.toString());

            String[] workerData = reader.readLine().split("\\s+");
            Worker worker = new Worker(workerData[0], workerData[1],
                    Double.parseDouble(workerData[2]), Double.parseDouble(workerData[3]));
            System.out.println(worker.toString());

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
