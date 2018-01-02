package app.waste_disposal.core;


import app.waste_disposal.contracts.InputReader;
import app.waste_disposal.contracts.OutputWriter;
import app.waste_disposal.factories.WasteFactory;

import java.util.Arrays;


public class Engine {

    private WasteController wasteController;
    private InputReader inputReader;
    private OutputWriter outputWriter;

    public Engine(InputReader inputReader, OutputWriter outputWriter, WasteController wasteController) {
        this.wasteController = wasteController;
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }
//⦁	ProcessGarbage {name}|{weight}|{volumePerKg}|{type}

    public void run(){
        while(true){
           String[] command = inputReader.readLine().split(" ");
           if("TimeToRecycle".equals(command[0])){
               break;
           }

           String result = dispatchCommand(command);
           if(result!= null){
               outputWriter.writeLine(result);
           }

        }
    }

    private String dispatchCommand(String[] command) {
        switch(command[0]){
            case "ProcessGarbage":
                return this.wasteController.processGarbageCommand(Arrays.asList(command[1].split("\\|")));
            case "Status":
                return this.wasteController.statusCommand();
            case "ChangeManagementRequirement":
                return this.wasteController.changeManagementRequirementCommand(Arrays.asList(command[1].split("\\|")));
            default:
                throw new IllegalArgumentException("Invalid command!");
        }
    }
}
