package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.exceptions.InvalidCommandException;
import main.bg.softuni.io.contracts.DirectoryManager;
import main.bg.softuni.io.contracts.Executable;

@Alias("cdrel")
public class ChangeRelativePathCommand extends Command implements Executable {

    @Inject
    private DirectoryManager ioManager;

    public ChangeRelativePathCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidCommandException(this.getInput());
        }

        String relativePath = data[1];
        this.ioManager.changeCurrentDirRelativePath(relativePath);
    }
}
