package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.exceptions.InvalidCommandException;
import main.bg.softuni.io.contracts.DirectoryManager;
import main.bg.softuni.io.contracts.Executable;

@Alias("cdabs")
public class ChangeAbsolutePathCommand extends Command implements Executable{

    @Inject
    private DirectoryManager ioManager;

    public ChangeAbsolutePathCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidCommandException(this.getInput());
        }

        String absolutePath = data[1];
        this.ioManager.changeCurrentDirAbsolute(absolutePath);
    }
}
