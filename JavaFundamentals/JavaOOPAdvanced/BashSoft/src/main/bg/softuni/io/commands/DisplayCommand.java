package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.dataStructures.contracts.SimpleOrderedBag;
import main.bg.softuni.exceptions.InvalidCommandException;
import main.bg.softuni.io.OutputWriter;
import main.bg.softuni.io.contracts.Executable;
import main.bg.softuni.models.contracts.Course;
import main.bg.softuni.models.contracts.Student;
import main.bg.softuni.repository.contracts.Database;

import java.util.Comparator;

@Alias("display")
public class DisplayCommand extends Command implements Executable {

    @Inject
    private Database repository;

    public DisplayCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if(data.length != 3){
            throw new InvalidCommandException(this.getInput());
        }

        String entityToDisplay = data[1];
        String sortType = data[2];
        if("students".equalsIgnoreCase(entityToDisplay)){
            Comparator<Student> studentComparator =
                    this.createComparator(Student.class, sortType);
            SimpleOrderedBag<Student> list =
                    this.repository.getAllStudentsSorted(studentComparator);
            OutputWriter.writeMessageOnNewLine(
                    list.joinWith(System.lineSeparator()));
        } else if("courses".equalsIgnoreCase(entityToDisplay)){
            Comparator<Course> courseComparator =
                    this.createComparator(Course.class, sortType);
            SimpleOrderedBag<Course> list =
                    this.repository.getAllCoursesSorted(courseComparator);
            OutputWriter.writeMessageOnNewLine(
                    list.joinWith(System.lineSeparator()));
        }else{
            throw new InvalidCommandException(this.getInput());
        }
    }

    private <T extends Comparable<T>> Comparator<T> createComparator(Class<T> clazz, String sortType) {
        if("ascending".equalsIgnoreCase(sortType)){
            return (o1,o2) -> o1.compareTo(o2);
        }else if("descending".equalsIgnoreCase(sortType)){
            return (o1,o2) -> o2.compareTo(o1);
        }else {
            throw new InvalidCommandException(this.getInput());
        }
    }
}
