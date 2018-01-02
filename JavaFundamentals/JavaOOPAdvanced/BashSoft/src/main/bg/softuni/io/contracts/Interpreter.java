package main.bg.softuni.io.contracts;

import java.io.IOException;

public interface Interpreter {
    void interpretCommand(String input) throws IOException;
}
