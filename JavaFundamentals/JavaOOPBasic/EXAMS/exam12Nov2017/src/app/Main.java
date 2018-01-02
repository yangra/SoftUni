package app;

import app.core.Engine;
import app.io.ConsoleOutputWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        Engine engine = new Engine(outputWriter);
        try{
            engine.run();
        }catch (IOException ioe){
            outputWriter.writeLine(ioe.getMessage());
        }
    }
}
