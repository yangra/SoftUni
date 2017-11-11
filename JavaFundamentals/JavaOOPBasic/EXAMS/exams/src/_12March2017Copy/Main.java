package _12March2017Copy;



import _12March2017Copy.core.CarManager;
import _12March2017Copy.engines.Engine;
import _12March2017Copy.io.ConsoleInputReader;
import _12March2017Copy.io.ConsoleOutputWriter;
import _12March2017Copy.utilities.InputParser;

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
