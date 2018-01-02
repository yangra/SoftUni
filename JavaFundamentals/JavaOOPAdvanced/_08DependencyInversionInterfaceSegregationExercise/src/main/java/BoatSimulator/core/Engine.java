package BoatSimulator.core;

import BoatSimulator.contracts.CommandHandler;
import BoatSimulator.contracts.Runnable;
import BoatSimulator.io.InputReader;
import BoatSimulator.io.OutputWriter;

public class Engine implements Runnable {

    private CommandHandler commandHandler;
    private InputReader inputReader;
    private OutputWriter outputWriter;

    public Engine(InputReader inputReader, OutputWriter outputWriter, CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void run() {
        StringBuilder output = new StringBuilder();
        while (true) {
            try {
                String line = inputReader.readLine();

                if (line.equals("End")) {
                    break;
                }

                String[] tokens = line.split("\\\\");
                String commandResult = this.commandHandler.executeCommand(tokens);
                if (commandResult != null) {
                    output.append(commandResult).append(System.lineSeparator());
                }
            } catch (Exception ex) {
                output.append(ex.getMessage()).append(System.lineSeparator());
            }
        }

        this.outputWriter.writeLine(output.toString().trim());
    }
}

