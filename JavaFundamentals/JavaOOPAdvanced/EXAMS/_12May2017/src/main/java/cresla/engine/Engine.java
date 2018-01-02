package cresla.engine;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {

    private static final String TERMINATING_COMMAND = "Exit";

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Manager reactorManager;

    public Engine(InputReader inputReader, OutputWriter outputWriter, Manager reactorManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.reactorManager = reactorManager;
    }

    public void run() {
        while (true) {
            String[] input = inputReader.readLine().split("\\s+");


            List<String> args = Arrays.stream(input).skip(1).collect(Collectors.toList());

            String output = null;
            try {
                switch (input[0]) {
                    case "Reactor":
                        output = reactorManager.reactorCommand(args);
                        break;
                    case "Module":
                        output = reactorManager.moduleCommand(args);
                        break;
                    case "Report":
                        output = reactorManager.reportCommand(args);
                        break;
                    case "Exit":
                        output = reactorManager.exitCommand(args);
                        break;
                }
            } catch (Exception e) {
                this.outputWriter.writeLine(e.getMessage());
            }

            if(output != null){
              this.outputWriter.writeLine(output);
            }

            if (TERMINATING_COMMAND.equals(input[0])) {
                break;
            }
        }
    }
}
