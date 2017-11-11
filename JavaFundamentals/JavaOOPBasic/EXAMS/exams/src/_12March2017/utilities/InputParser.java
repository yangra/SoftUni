package _12March2017.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<String> parseInput(String inputLine){
        return new ArrayList<>(Arrays.asList(inputLine.split("\\s+")));
    }
}
