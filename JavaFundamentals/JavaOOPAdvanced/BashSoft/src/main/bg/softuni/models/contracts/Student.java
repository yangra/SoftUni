package main.bg.softuni.models.contracts;

import java.util.Map;

public interface Student extends Comparable<Student> {

    String getUsername();

    Map<String, Course> getEnrolledCourses();

    Map<String, Double> getMarksByCourseName();

    void enrollInCourse(Course course);

    void setMarkOnCourse(String courseName, int... scores);

    String getMarkForCourse(String courseName);

}
