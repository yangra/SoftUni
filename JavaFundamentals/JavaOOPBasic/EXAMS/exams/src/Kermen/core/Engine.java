package Kermen.core;

import Kermen.io.ConsoleInputReader;
import Kermen.io.ConsoleOutputWriter;
import Kermen.utilities.InputParser;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Engine {

    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private HomeManager manager;

    public Engine() {
        this.inputReader = new ConsoleInputReader();
        this.outputWriter = new ConsoleOutputWriter();
        this.inputParser = new InputParser();
        this.manager = new HomeManager();
    }

    public void run() throws IOException {

        int counter = 1;
        while (true) {
            String inputLine = this.inputReader.readLine();
            if ("Democracy".equalsIgnoreCase(inputLine)) {
                break;
            }

            String[] commandParams = this.inputParser.parseInput(inputLine);
            this.dispatchCommand(commandParams, counter);
            counter++;
        }

        this.outputWriter.writeLine(String.format("Total population: %d", this.manager.getPopulation()));
    }

    private void dispatchCommand(String[] commandParams, int counter) {
        DecimalFormat df = new DecimalFormat("0.0#############");
        String command = commandParams[0].contains("(") ?
                commandParams[0].substring(0, commandParams[0].indexOf("("))
                : commandParams[0];
        Pattern pattern = Pattern.compile("[.\\d]+");
        Matcher matcher = pattern.matcher(commandParams[0]);

        switch (command.toLowerCase()) {
            case "youngcouplewithchildren":
                List<String> homeArgs = new ArrayList<>();
                List<List<String>> children = new ArrayList<>();
                while (matcher.find()) {
                    homeArgs.add(matcher.group());
                }
                for (int i = 1; i < commandParams.length; i++) {
                    Matcher childMatcher = pattern.matcher(commandParams[i]);
                    List<String> child = new ArrayList<>();
                    while (childMatcher.find()) {
                        child.add(childMatcher.group());
                    }
                    children.add(child);
                }
                this.manager.registerYoungCoupleWithChildren(homeArgs, children);
                checkIfPayDay(counter);
                break;
            case "youngcouple":
                homeArgs = new ArrayList<>();
                while (matcher.find()) {
                    homeArgs.add(matcher.group());
                }
                this.manager.registerYoungCouple(homeArgs);
                checkIfPayDay(counter);
                break;
            case "aloneyoung":
                homeArgs = new ArrayList<>();
                while (matcher.find()) {
                    homeArgs.add(matcher.group());
                }
                this.manager.registerAloneYoung(homeArgs);
                checkIfPayDay(counter);
                break;
            case "aloneold":
                homeArgs = new ArrayList<>();
                while (matcher.find()) {
                    homeArgs.add(matcher.group());
                }
                this.manager.registerAloneOld(homeArgs);
                checkIfPayDay(counter);
                break;
            case "oldcouple":
                homeArgs = new ArrayList<>();
                while (matcher.find()) {
                    homeArgs.add(matcher.group());
                }
                this.manager.registerOldCouple(homeArgs);
                checkIfPayDay(counter);
                break;
            case "evn":
                checkIfPayDay(counter);
                this.outputWriter.writeLine(String.format("Total consumption: %s", df.format(this.manager.calculateConsumption())));
                break;
            case "evn bill":
                checkIfPayDay(counter);
                this.manager.payAllBills();
                break;
        }
    }

    private void checkIfPayDay(int counter) {
        if(counter%3 == 0){
            this.manager.paySalaries();
        }
    }
}