package Repository;

import IO.OutputWriter;
import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentsRepository {
    private static boolean isDataInitialized = false;
    private static HashMap<String, HashMap<String, ArrayList<Integer>>> studentsByCourse;

    public static void initializeData(String fileName) {
        if (isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }

        studentsByCourse = new HashMap<>();
        readData(fileName);
    }

    public static void prinFilteredStudents(String course,
                                            String filter,
                                            Integer numberOfStudents){
        if(!isQueryForCoursePossible(course)){
            return;
        }

        if(numberOfStudents == null){
            numberOfStudents = studentsByCourse.get(course).size();
        }

        RepositoryFilters.printFilteredStudents(studentsByCourse.get(course),filter,numberOfStudents);
    }
    public static void prinOrderedStudents(String course,
                                            String compareType,
                                            Integer numberOfStudents){
        if(!isQueryForCoursePossible(course)){
            return;
        }

        if(numberOfStudents == null){
            numberOfStudents = studentsByCourse.get(course).size();
        }

        RepositorySorters.printSortedStudents(studentsByCourse.get(course),compareType,numberOfStudents);
    }

    private static void readData(String fileName) {
        String regex = "([A-Z][a-zA-Z+#]*_[A-Z][a-z]{2}_\\d{4})\\s+([A-Z][a-z]{0,3}\\d{2}_\\d{2,4})\\s+(\\d{1,3})";
        Pattern validation = Pattern.compile(regex);
        Matcher matcher;

        String currentDirectory = SessionData.currentPath + File.separator + fileName;
        Path path = Paths.get(currentDirectory);
        try (BufferedReader bf = Files.newBufferedReader(path)) {
            String line = bf.readLine();

            while (line != null) {
                matcher = validation.matcher(line);
                if (!line.isEmpty() && matcher.find()) {
                    String course = matcher.group(1);
                    String student = matcher.group(2);
                    Integer mark = Integer.parseInt(matcher.group(3));

                    if (mark >= 0 && mark <= 100) {
                        studentsByCourse.putIfAbsent(course, new HashMap<>());
                        studentsByCourse.get(course).putIfAbsent(student, new ArrayList<>());
                        studentsByCourse.get(course).get(student).add(mark);
                    }
                }

                line = bf.readLine();
            }

            isDataInitialized = true;
            OutputWriter.writeMessageOnNewLine("Data read.");

        } catch (IOException e) {
            e.printStackTrace();
            OutputWriter.displayException(ExceptionMessages.DATA_NOT_INITIALIZED);
            studentsByCourse.clear();
        }
    }

    private static boolean isQueryForCoursePossible(String courseName) {
        if (!isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }

        if (!studentsByCourse.containsKey(courseName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_COURSE);
            return false;
        }
        return true;
    }

    private static boolean isQueryForStudentPossible(String courseName, String studentName) {
        if (!isQueryForCoursePossible(courseName)) {
            return false;
        }
        if (!studentsByCourse.containsKey(studentName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_STUDENT);
            return false;
        }

        return true;
    }

    public static void getStudentMarksInCourse(String course, String student) {
        if (!isQueryForStudentPossible(course, student)) {
            return;
        }

        ArrayList<Integer> marks = studentsByCourse.get(course).get(student);
        OutputWriter.printStudent(student, marks);
    }

    public static void getStudentsByCourse(String course) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }

        OutputWriter.writeMessageOnNewLine(course + ":");
        for (Map.Entry<String, ArrayList<Integer>> student : studentsByCourse.get(course).entrySet()) {
            OutputWriter.printStudent(student.getKey(), student.getValue());
        }
    }
}
