package hell;

import hell.core.Controller;
import hell.core.Engine;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputReader inputReader = new ConsoleInputReader(reader);
        OutputWriter outputWriter = new ConsoleOutputWriter();
        Engine engine = new Engine(inputReader,outputWriter,controller);

        engine.run();
    }
}