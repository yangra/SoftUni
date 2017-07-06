package P07;


import java.util.List;

public class Student {
    private String name;
    private List<Double> grades;
    private Double averageGrade;

    public Student(String name, List<Double> grades){
        this.name = name;
        this.grades = grades;
    }

    public String getName(){
        return this.name;
    }
    public Double getAverageGrade(){
        return grades.stream().mapToDouble(a->a/grades.size()).sum();
    }
}
