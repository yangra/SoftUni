package _03September2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class P04ActivityTracker {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer,Map<String,Integer>> activities = new TreeMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            String[] date = input[0].split("/");
            Integer month = Integer.parseInt(date[1]);
            String name = input[1];
            Integer distance = Integer.parseInt(input[2]);

            Map<String, Integer> person = new TreeMap<>();
            if(activities.containsKey(month)){
                person = activities.get(month);
                if(person.containsKey(name)){
                    person.put(name,person.get(name)+distance);
                }else{
                    person.put(name,distance);
                }
            }else{
                person.put(name,distance);
            }
            activities.put(month,person);
        }

        for (Map.Entry<Integer, Map<String, Integer>> month : activities.entrySet()) {
            System.out.printf("%d: ",month.getKey());
            int counter = 0;
            for (Map.Entry<String, Integer> person : month.getValue().entrySet()) {
                System.out.printf("%s(%d)", person.getKey(), person.getValue());
                if(counter != month.getValue().size()-1){
                    System.out.print(", ");
                }
                counter++;
            }
            System.out.println();
        }
    }
}
