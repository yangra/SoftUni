package _13March2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class P04ChampionsLeague {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> wins = new TreeMap<>();
        Map<String, TreeSet<String>> teams = new TreeMap<>();

        while (true) {
            String[] input = reader.readLine().split(" \\| ");
            if (input[0].equals("stop")) {
                break;
            }

            String team1 = input[0];
            String team2 = input[1];

            String[] home = input[2].split(":");
            String[] away = input[3].split(":");

            Integer team1home = Integer.parseInt(home[0]);
            Integer team2home = Integer.parseInt(home[1]);
            Integer team1away = Integer.parseInt(away[1]);
            Integer team2away = Integer.parseInt(away[0]);

            if (team1home + team1away > team2home + team2away) {
                String winner = team1;
                String loser = team2;
                fillMaps(wins, teams, winner, loser);

            } else if (team1home + team1away < team2home + team2away) {
                String winner = team2;
                String loser = team1;
                fillMaps(wins, teams, winner, loser);
            } else {
                String winner = team1away > team2home ? team1 : team2;
                String loser = team1away > team2home ? team2 : team1;
                fillMaps(wins,teams,winner,loser);
            }

        }

        wins.entrySet().stream()
                .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                .forEach(me-> System.out.printf("%s\n- Wins: %d\n- Opponents: %s\n", me.getKey(), me.getValue(),
                         teams.get(me.getKey()).toString().replaceAll("[\\[\\]]","")));
    }

    private static void fillMaps(Map<String, Integer> wins, Map<String, TreeSet<String>> teams, String winner, String loser) {
        teams.putIfAbsent(winner, new TreeSet<>());
        teams.putIfAbsent(loser, new TreeSet<>());
        teams.get(winner).add(loser);
        teams.get(loser).add(winner);
        wins.putIfAbsent(loser,0);
        wins.putIfAbsent(winner,0);
        wins.put(winner,wins.get(winner)+1);
    }
}
