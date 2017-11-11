package _08May2017;


import _08May2017.core.Engine;
import _08May2017.core.NationManager;
import _08May2017.io.ConsoleInputReader;
import _08May2017.io.ConsoleOutputWriter;
import _08May2017.utilities.InputParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        NationManager nationManager = new NationManager();
        Engine engine = new Engine(inputReader,outputWriter,inputParser,nationManager);
        try {
            engine.run();
        }catch(IOException ioe){
            outputWriter.writeLine(ioe.getMessage());
        }
    }
}
