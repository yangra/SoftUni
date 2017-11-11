package _12March2017;

import _12March2017.core.CarManager;
import _12March2017.core.Engine;
import _12March2017.io.ConsoleInputReader;
import _12March2017.io.ConsoleOutputWriter;
import _12March2017.utilities.InputParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        CarManager carManager = new CarManager();
        Engine engine = new Engine(inputReader,outputWriter,inputParser, carManager);
        try {
            engine.run();
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}
