package _09Nov2017.engine;


import _09Nov2017.core.AnimalCenterManager;
import _09Nov2017.io.ConsoleInputReader;
import _09Nov2017.io.ConsoleOutputWriter;
import _09Nov2017.utilities.InputParser;

import java.io.IOException;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private AnimalCenterManager animalCenterManager;

    public Engine() {
        this.inputReader  = new ConsoleInputReader();
        this.outputWriter  = new ConsoleOutputWriter();
        this.inputParser = new InputParser();
        this.animalCenterManager = new AnimalCenterManager();
    }

    public void run() throws IOException {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            if ("Paw Paw Pawah".equalsIgnoreCase(inputLine)) {
                break;
            }
            String[] commandParams = this.inputParser.parseInput(inputLine);
            this.dispatchCommand(commandParams);
        }

        this.animalCenterManager.printStatistics();
    }

    private void dispatchCommand(String[] params) {
        switch (params[0]){
            case "RegisterCleansingCenter":
                this.animalCenterManager.registerCleansingCenter(params[1]);
                break;
            case "RegisterAdoptionCenter":
                this.animalCenterManager.registerAdoptionCenter(params[1]);
                break;
            case "RegisterCastrationCenter":
                this.animalCenterManager.registerCastrationCenter(params[1]);
                break;
            case "RegisterDog":
                this.animalCenterManager.registerDog(params[1], Integer.parseInt(params[2]), Integer.parseInt(params[3]), params[4]);
                break;
            case "RegisterCat":
                this.animalCenterManager.registerCat(params[1], Integer.parseInt(params[2]), Integer.parseInt(params[3]), params[4]);
                break;
            case "SendForCleansing":
                this.animalCenterManager.sendForCleansing(params[1], params[2]);
                break;

            case "SendForCastration":
                this.animalCenterManager.sendForCastration(params[1], params[2]);
                break;
            case "Cleanse":
                this.animalCenterManager.cleanse(params[1]);
                break;
            case "Castrate":
                this.animalCenterManager.castrate(params[1]);
                break;
            case "Adopt":
                this.animalCenterManager.adopt(params[1]);
                break;
            case "CastrationStatistics":
                this.animalCenterManager.castrationStatistics();
                break;
            default:
                break;
        }
    }

}
