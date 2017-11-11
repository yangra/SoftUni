package _17Oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P04HighScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Long> totalScores = new HashMap<>();
        Map<String, List<String>> duels = new HashMap<>();

        while (true) {
            String[] input = reader.readLine().split(" ");
            if ("osu!".equals(input[0])) {
                break;
            }

            long playerOneResult = Integer.parseInt(input[0]) - Integer.parseInt(input[2]);
            long playerTwoResult = Integer.parseInt(input[2]) - Integer.parseInt(input[0]);

            String[] players = input[1].split("<->");
            String playerOne = players[0];
            String playerTwo = players[1];

            totalScores.putIfAbsent(playerOne, 0L);
            totalScores.putIfAbsent(playerTwo, 0L);
            totalScores.put(playerOne, totalScores.get(playerOne) + playerOneResult);
            totalScores.put(playerTwo, totalScores.get(playerTwo) + playerTwoResult);

            duels.putIfAbsent(playerOne, new ArrayList<>());
            duels.putIfAbsent(playerTwo, new ArrayList<>());
            duels.get(playerOne).add(String.format("*   %s <-> %d", playerTwo, playerOneResult));
            duels.get(playerTwo).add(String.format("*   %s <-> %d", playerOne, playerTwoResult));
        }

        totalScores = totalScores.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, Long> score : totalScores.entrySet()) {
            System.out.printf("%s - (%d)\n", score.getKey(), score.getValue());
            duels.get(score.getKey()).forEach(System.out::println);
        }
    }
}
