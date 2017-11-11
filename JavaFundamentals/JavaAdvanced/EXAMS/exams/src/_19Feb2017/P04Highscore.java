package _19Feb2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P04Highscore {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Long> totalScores = new LinkedHashMap<>();
        Map<String, List<String>> players = new LinkedHashMap<>();

        while (true) {
            String[] scores = reader.readLine().split("<->");
            if ("osu!".equalsIgnoreCase(scores[0])) {
                break;
            }
            String playerOne = scores[0].split(" ")[1];
            String playerTwo = scores[1].split(" ")[0];
            Long scoreOne = Long.parseLong(scores[0].split(" ")[0]);
            Long scoreTwo = Long.parseLong(scores[1].split(" ")[1]);

            if(totalScores.containsKey(playerOne)){
                totalScores.put(playerOne,totalScores.get(playerOne)+(scoreOne-scoreTwo));
            }else{
                totalScores.put(playerOne, scoreOne-scoreTwo);
            }

            if(totalScores.containsKey(playerTwo)){
                totalScores.put(playerTwo,totalScores.get(playerTwo)+(scoreTwo-scoreOne));
            }else{
                totalScores.put(playerTwo, scoreTwo-scoreOne);
            }

            List<String> result = new ArrayList<>();
            if (players.containsKey(playerOne)) {
                result = players.get(playerOne);
            }
            result.add(String.format("%s <-> %d", playerTwo, scoreOne - scoreTwo));
            players.put(playerOne, result);

            result = new ArrayList<>();
            if (players.containsKey(playerTwo)) {
                result = players.get(playerTwo);
            }
            result.add(String.format("%s <-> %d", playerOne, scoreTwo - scoreOne));
            players.put(playerTwo, result);
        }

        totalScores = totalScores.entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(o,n)->o,LinkedHashMap::new));
        for (Map.Entry<String, Long> entry : totalScores.entrySet()) {
            System.out.printf("%s - (%d)\n", entry.getKey(), entry.getValue());
            for (String opponent : players.get(entry.getKey())) {
                System.out.printf("*   %s\n", opponent);
            }
        }
    }
}
