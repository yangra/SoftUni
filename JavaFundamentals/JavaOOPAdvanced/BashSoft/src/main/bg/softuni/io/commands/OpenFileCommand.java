package main.bg.softuni.io.commands;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.exceptions.InvalidCommandException;
import main.bg.softuni.io.contracts.Executable;
import main.bg.softuni.staticData.SessionData;

import java.awt.*;
import java.io.File;

@Alias("open")
public class OpenFileCommand extends Command implements Executable {

    public OpenFileCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidCommandException(this.getInput());
        }

        String fileName = data[1];
        String filePath = SessionData.currentPath + "\\" + fileName;
        File file = new File(filePath);
        Desktop.getDesktop().open(file);
    }
}
