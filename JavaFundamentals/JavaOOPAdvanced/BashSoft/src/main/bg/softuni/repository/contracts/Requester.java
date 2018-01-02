package main.bg.softuni.repository.contracts;

import main.bg.softuni.dataStructures.contracts.SimpleOrderedBag;
import main.bg.softuni.models.contracts.Course;
import main.bg.softuni.models.contracts.Student;

import java.util.Comparator;

public interface Requester {

    void getStudentMarksInCourse(String courseName, String studentName);

    void getStudentsByCourse(String courseName);

    SimpleOrderedBag<Course> getAllCoursesSorted(Comparator<Course> cmp);

    SimpleOrderedBag<Student> getAllStudentsSorted(Comparator<Student> cmp);
}
