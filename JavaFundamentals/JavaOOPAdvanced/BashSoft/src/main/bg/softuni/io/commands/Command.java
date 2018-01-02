package main.bg.softuni.io.commands;

import main.bg.softuni.exceptions.InvalidCommandException;
import main.bg.softuni.io.contracts.Executable;

public abstract class Command implements Executable{
    private String input;
    private String[] data;

    protected Command(String input,
                      String[] data) {
        this.setInput(input);
        this.setData(data);
    }

    protected String getInput() {
        return this.input;
    }

    private void setInput(String input) {
        if (input == null || input.equals("")) {
            throw new InvalidCommandException(this.input);
        }

        this.input = input;
    }

    protected String[] getData() {
        return this.data;
    }

    private void setData(String[] data) {
        if (data == null || data.length < 1) {
            throw new InvalidCommandException(this.input);
        }

        this.data = data;
    }

    public abstract void execute() throws Exception;
}

