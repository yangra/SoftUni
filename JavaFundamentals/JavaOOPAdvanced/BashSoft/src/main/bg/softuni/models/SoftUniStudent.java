package main.bg.softuni.models;

import main.bg.softuni.models.contracts.Course;
import main.bg.softuni.models.contracts.Student;
import main.bg.softuni.exceptions.DuplicateEntryInStructureException;
import main.bg.softuni.exceptions.InvalidStringException;
import main.bg.softuni.exceptions.KeyNotFoundException;
import main.bg.softuni.staticData.ExceptionMessages;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class SoftUniStudent implements Student {
    private String username;
    private LinkedHashMap<String, Course> enrolledCourses;
    private LinkedHashMap<String, Double> marksByCourseName;

    public SoftUniStudent(String username) {
        this.setUsername(username);
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourseName = new LinkedHashMap<>();
    }

    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        if(username == null||username.trim().isEmpty()){
            throw new InvalidStringException();
        }
        this.username = username;
    }

    public Map<String, Course> getEnrolledCourses() {
        return Collections.unmodifiableMap(this.enrolledCourses);
    }

    public Map<String, Double> getMarksByCourseName() {
        return Collections.unmodifiableMap(this.marksByCourseName);
    }


    public void enrollInCourse(Course course) {
        if (this.enrolledCourses.containsKey(course.getName())) {
            throw new DuplicateEntryInStructureException(this.username, course.getName());

        }

        this.enrolledCourses.put(course.getName(), course);
    }

    public void setMarkOnCourse(String courseName, int... scores) {
        if (!this.enrolledCourses.containsKey(courseName)) {
            throw new KeyNotFoundException();
        }

        if (scores.length > SoftUniCourse.NUMBER_OF_TASKS_ON_EXAM) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
        }

        double mark = calculateMark(scores);
        this.marksByCourseName.put(courseName, mark);
    }

    private double calculateMark(int[] scores) {
        double percentageOfSolvedExam = Arrays.stream(scores).sum()/
                (double) (SoftUniCourse.NUMBER_OF_TASKS_ON_EXAM* SoftUniCourse.MAX_SCORE_ON_EXAM_TASK);
        double mark = percentageOfSolvedExam * 4 +2;
        return mark;
    }

    public String getMarkForCourse(String courseName) {
        String output = String.format("%s - %f",
                this.username, marksByCourseName.get(courseName));
        return output;
    }

    @Override
    public int compareTo(Student other) {
        return this.getUsername().compareTo(other.getUsername());
    }

    @Override
    public String toString() {
        return this.getUsername();
    }
}
