package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.exceptions.InvalidCommandException;
import main.bg.softuni.io.contracts.DirectoryManager;
import main.bg.softuni.io.contracts.Executable;

@Alias("ls")
public class TraverseFoldersCommand extends Command implements Executable {

    @Inject
    private DirectoryManager iotManager;

    public TraverseFoldersCommand(String input,
                                  String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 1 && data.length != 2) {
            throw new InvalidCommandException(this.getInput());
        }

        if (data.length == 1) {
            this.iotManager.traverseDirectory(0);
            return;
        }

        this.iotManager.traverseDirectory(Integer.valueOf(data[1]));
    }
}
