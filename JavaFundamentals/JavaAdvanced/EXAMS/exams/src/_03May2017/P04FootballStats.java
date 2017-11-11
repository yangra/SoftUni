package _03May2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P04FootballStats {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> games = new LinkedHashMap<>();

        while (true) {
            String[] input = reader.readLine().split(" result ");
            if ("Season end".equalsIgnoreCase(input[0])) {
                break;
            }

            String[] teams = input[0].split(" - ");
            String[] results = input[1].split(":");

            List<String> opponent = new ArrayList<>();
            if (games.containsKey(teams[0])) {
                opponent = games.get(teams[0]);
            }
            opponent.add(teams[1] + " -> " + results[0] + ":" + results[1]);
            games.put(teams[0], opponent);


            opponent = new ArrayList<>();
            if (games.containsKey(teams[1])) {
                opponent = games.get(teams[1]);
            }
            opponent.add(teams[0] + " -> " + results[1] + ":" + results[0]);
            games.put(teams[1], opponent);
        }

        String[] players = reader.readLine().split(", ");

        for (String player : players) {
            for (Map.Entry<String, List<String>> mainPlayer : games.entrySet()) {
                if (mainPlayer.getKey().equals(player)) {
                    List<String> result = games.get(player).stream().sorted((a, b) -> (a.charAt(0) + "").compareTo(b.charAt(0) + "")).collect(Collectors.toList());
                    for (String opponent : result) {
                        System.out.printf("%s - %s\n", player, opponent);
                    }
                }
            }
        }
    }
}
