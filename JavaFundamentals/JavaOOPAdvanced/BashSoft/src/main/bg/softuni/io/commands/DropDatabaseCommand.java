package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.exceptions.InvalidCommandException;
import main.bg.softuni.io.OutputWriter;
import main.bg.softuni.io.contracts.Executable;
import main.bg.softuni.repository.contracts.Database;

@Alias("dropdb")
public class DropDatabaseCommand extends Command implements Executable {

    @Inject
    private Database repository;

    public DropDatabaseCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 1) {
            throw new InvalidCommandException(this.getInput());
        }

        this.repository.unloadData();
        OutputWriter.writeMessageOnNewLine("Database dropped!");
    }
}
