package _08May2017.core;


import _08May2017.io.ConsoleInputReader;
import _08May2017.io.ConsoleOutputWriter;
import _08May2017.utilities.InputParser;

import java.io.IOException;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private NationManager nationManager;
    private static int  warCounter = 1;

    public Engine(ConsoleInputReader inputReader,
                  ConsoleOutputWriter outputWriter,
                  InputParser inputParser,
                  NationManager nationManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.nationManager = nationManager;
    }

    public void run() throws IOException {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            if ("Quit".equalsIgnoreCase(inputLine)) {
                break;
            }
            String[] command = this.inputParser.parseInput(inputLine);
            this.dispatchCommand(command);
        }

        for (String war : NationManager.wars) {
            outputWriter.writeLine(war);
        }
    }

    private void dispatchCommand(String[] command) {
        switch (command[0]) {
            case "Bender":
                this.nationManager.makeBender(command[1],
                        command[2],
                        Integer.parseInt(command[3]),
                        Double.parseDouble(command[4]));
                break;
            case "Monument":
                this.nationManager.makeMonument(command[1],
                        command[2],
                        Integer.parseInt(command[3]));
                break;
            case "Status":
                this.outputWriter.writeLine(this.nationManager.getStatus(command[1]));
                break;
            case "War":
                this.nationManager.beginWar(command[1], this.warCounter++);
                break;
            default:
                break;
        }
    }

}
