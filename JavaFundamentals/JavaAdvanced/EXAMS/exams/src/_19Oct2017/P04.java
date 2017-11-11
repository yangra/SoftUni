package _19Oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> result = new TreeMap<>();
        while (true){
            String[] input = reader.readLine().split(" - ");
            if("Season End".equals(input[0])){
                break;
            }
            String team = input[0];
            String[] input2 = input[1].split(" ");
            String opponent = input2[0];
            String[] results = input2[2].split(":");

            result.putIfAbsent(team,new ArrayList<>());
            result.get(team).add(String.format("%s -> %s:%s", opponent,results[0],results[1]));

            result.putIfAbsent(opponent,new ArrayList<>());
            result.get(opponent).add(String.format("%s -> %s:%s", team,results[1],results[0]));
        }

        List<String> teams = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());

        for (String team : teams) {
            for (Map.Entry<String, List<String>> entry : result.entrySet()) {
                if(team.equals(entry.getKey())){
                    entry.getValue().stream()
                            .sorted((a,b)->a.substring(0,3).compareTo(b.substring(0,3)))
                            .forEach(s-> System.out.printf("%s - %s\n",entry.getKey(), s));
                }
            }
        }
    }
}
