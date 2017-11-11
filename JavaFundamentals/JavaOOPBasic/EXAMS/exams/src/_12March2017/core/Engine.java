package _12March2017.core;

import _12March2017.io.ConsoleInputReader;
import _12March2017.io.ConsoleOutputWriter;
import _12March2017.utilities.InputParser;

import java.io.IOException;
import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private CarManager carManager;

    public Engine(ConsoleInputReader inputReader,
                  ConsoleOutputWriter outputWriter,
                  InputParser inputParser,
                  CarManager carManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.carManager = carManager;
    }

    public void run() throws IOException {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            if ("Cops are here".equalsIgnoreCase(inputLine)) {
                break;
            }
            List<String> commandParams = this.inputParser.parseInput(inputLine);
            this.dispatchCommand(commandParams);
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);
        String[] params = commandParams.toArray(new String[0]);

        switch (command) {
            case "register":
                this.carManager.register(Integer.parseInt(params[0]),
                        params[1],
                        params[2],
                        params[3],
                        Integer.parseInt(params[4]),
                        Integer.parseInt(params[5]),
                        Integer.parseInt(params[6]),
                        Integer.parseInt(params[7]),
                        Integer.parseInt(params[8]));
                break;
            case "check":
                String result = this.carManager.check(Integer.parseInt(params[0]));
                this.outputWriter.writeLine(result);
                break;
            case "open":
                if (params.length == 5) {
                    this.carManager.open(Integer.parseInt(params[0]),
                            params[1],
                            Integer.parseInt(params[2]),
                            params[3],
                            Integer.parseInt(params[4]));
                } else {
                    this.carManager.open(Integer.parseInt(params[0]),
                            params[1],
                            Integer.parseInt(params[2]),
                            params[3],
                            Integer.parseInt(params[4]),
                            Integer.parseInt(params[5]));
                }
                break;
            case "participate":
                this.carManager.participate(Integer.parseInt(params[0]),
                        Integer.parseInt(params[1]));
                break;
            case "start":
                result = this.carManager.start(Integer.parseInt(params[0]));
                this.outputWriter.writeLine(result);
                break;
            case "park":
                this.carManager.park(Integer.parseInt(params[0]));
                break;
            case "unpark":
                this.carManager.unpark(Integer.parseInt(params[0]));
                break;
            case "tune":
                this.carManager.tune(Integer.parseInt(params[0]),
                        params[1]);
                break;
            default:
                break;
        }
    }
}
