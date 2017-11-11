package Kermen.utilities;

public class InputParser {
    public String[] parseInput(String inputLine){
        return inputLine.split(" Child");
    }

    public String[] splitByBrackets(String input){
        return input.split("[)(]");
    }
}
