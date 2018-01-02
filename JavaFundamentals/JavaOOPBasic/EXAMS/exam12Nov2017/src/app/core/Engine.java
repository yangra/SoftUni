package app.core;

import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

import java.io.IOException;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private HealthManager healthManager;

    public Engine(ConsoleOutputWriter outputWriter) {
        this.inputReader = new ConsoleInputReader();
        this.outputWriter = outputWriter;
        this.inputParser = new InputParser();
        this.healthManager = new HealthManager();
    }

    public void run() throws IOException {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            if ("BEER IS COMING".equalsIgnoreCase(inputLine)) {
                break;
            }
            String[] params = this.inputParser.parseInput(inputLine);

            String output = this.dispatchCommand(params);
            if(output!=null){
                this.outputWriter.writeLine(output);
            }
        }
    }

    private String dispatchCommand(String[] params) {

        switch (params[0].toLowerCase()) {
            case "checkcondition":
                return this.healthManager.checkCondition(params[1]);
            case "createorganism":
                return this.healthManager.createOrganism(params[1]);
            case "addcluster":
                return this.healthManager.addCluster(params[1], params[2],
                        Integer.parseInt(params[3]), Integer.parseInt(params[4]));
            case "addcell":
                return this.healthManager.addCell(params[1], params[2], params[3], params[4],
                        Integer.parseInt(params[5]), Integer.parseInt(params[6]),
                        Integer.parseInt(params[7]), Integer.parseInt(params[8]));
            case "activatecluster":
                return this.healthManager.activateCluster(params[1]);
            default:
                return null;
        }
    }
}
