package P10;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        Map<String, String> students = new LinkedHashMap<>();
        while (!"END".equals(line)) {
            String[] data = line.split("\\s");
            students.put(data[0] + " " + data[1], data[2]);
            line = reader.readLine();
        }

        students.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey,Collectors.joining(", "))))
                .entrySet()
                .forEach(s-> System.out.println(s.getKey()+ " - " + s.getValue()));
    }

}
