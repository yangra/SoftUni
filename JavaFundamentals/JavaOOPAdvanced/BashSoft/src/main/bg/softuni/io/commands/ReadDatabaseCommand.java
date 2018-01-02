package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.exceptions.InvalidCommandException;
import main.bg.softuni.io.contracts.Executable;
import main.bg.softuni.repository.contracts.Database;

@Alias("readdb")
public class ReadDatabaseCommand extends Command implements Executable {

    @Inject
    private Database repository;

    public ReadDatabaseCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidCommandException(this.getInput());
        }

        String fileName = data[1];
        this.repository.loadData(fileName);
    }
}
