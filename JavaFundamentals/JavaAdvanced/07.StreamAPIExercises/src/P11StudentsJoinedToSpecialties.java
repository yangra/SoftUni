import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P11StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<StudentSpecialty> specialties = new ArrayList<>();
        while (true) {
            String[] specialty = reader.readLine().split(" ");
            if ("Students:".equalsIgnoreCase(specialty[0])) {
                break;
            }

            specialties.add(new StudentSpecialty(specialty[0] + " " + specialty[1], Integer.valueOf(specialty[2])));
        }

        List<Student> students = new ArrayList<>();
        while (true) {
            String[] person = reader.readLine().split(" ");
            if ("END".equalsIgnoreCase(person[0])) {
                break;
            }

            students.add(new Student(person[1] + " " + person[2], Integer.valueOf(person[0])));
        }

        students = students.stream()
                .sorted((st1,st2)->st1.getStudentName().compareTo(st2.getStudentName()))
                .collect(Collectors.toList());

        for (Student student : students) {
            for (StudentSpecialty specialty : specialties) {
                if(student.getFacultyNumber().equals(specialty.getFacultyNumber())){
                    System.out.printf("%s %d %s\n",student.getStudentName(),student.getFacultyNumber(),specialty.getSpecialtyName());
                }
            }
        }

    }

    public static class StudentSpecialty {
        private String specialtyName;
        private Integer facultyNumber;

        StudentSpecialty(String specialtyName, Integer facultyNumber) {
            this.specialtyName = specialtyName;
            this.facultyNumber = facultyNumber;
        }

        String getSpecialtyName() {
            return specialtyName;
        }

        Integer getFacultyNumber() {
            return facultyNumber;
        }
    }

    public static class Student {
        private String studentName;
        private Integer facultyNumber;

        Student(String studentName, Integer facultyNumber) {
            this.studentName = studentName;
            this.facultyNumber = facultyNumber;
        }

        String getStudentName() {
            return studentName;
        }

        Integer getFacultyNumber() {
            return facultyNumber;
        }
    }
}
