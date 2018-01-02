package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.exceptions.InvalidCommandException;
import main.bg.softuni.io.contracts.Executable;
import main.bg.softuni.repository.contracts.Database;

@Alias("show")
public class ShowCourseCommand extends Command implements Executable {

    @Inject
    private Database repository;

    public ShowCourseCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2 && data.length != 3) {
            throw new InvalidCommandException(this.getInput());
        }

        if (data.length == 2) {
            String courseName = data[1];
            this.repository.getStudentsByCourse(courseName);
            return;
        }

        String courseName = data[1];
        String userName = data[2];
        this.repository.getStudentMarksInCourse(courseName, userName);

    }
}
