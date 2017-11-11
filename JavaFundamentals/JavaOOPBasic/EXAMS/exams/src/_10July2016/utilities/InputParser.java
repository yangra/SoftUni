package _10July2016.utilities;

public class InputParser {
    public String[] splitByBracket(String inputLine){
        return inputLine.split("[\\(\\)]");
    }

    public String[] splitByComa(String inputLine){
        return inputLine.split(", ");
    }
}
