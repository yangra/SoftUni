package main.bg.softuni.repository.contracts;

import java.util.HashMap;

public interface DataSorter {
    void printSortedStudents(
            HashMap<String, Double> studentsWithMarks,
            String comparisonType,
            int numberOfStudents);
}
