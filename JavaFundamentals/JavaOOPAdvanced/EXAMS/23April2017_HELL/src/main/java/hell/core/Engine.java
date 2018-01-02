package hell.core;

import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {

    private static final String TERMINATING_COMMAND = "Quit";

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Controller controller;

    public Engine(InputReader inputReader, OutputWriter outputWriter, Controller controller) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.controller = controller;
    }

//    Hero {heroName} {heroType}
//    Item {name} {heroName} {strengthBonus} {agilityBonus} {intelligenceBonus} {hitpointsBonus} {damageBonus}
//    Recipe {name} {heroName} {strengthBonus} {agilityBonus} {intelligenceBonus} {hitpointsBonus} {damageBonus} {requiredItem1} {requiredItem2}. . .
//    Inspect {heroName}
//    Quit

    public void run() {
        while (true) {
            String[] input = inputReader.readLine().split("\\s+");

            List<String> args = Arrays.stream(input).skip(1).collect(Collectors.toList());



            String output = null;
            try {
                switch (input[0]) {
                    case "Hero":
                        output = this.controller.heroCommand(args);
                        break;
                    case "Item":
                        output = this.controller.itemCommand(args);
                        break;
                    case "Recipe":
                        output = this.controller.recipeCommand(args);
                        break;
                    case "Inspect":
                        output = this.controller.inspectCommand(args);
                        break;
                    case "Quit":
                        output = this.controller.quitCommand();
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
