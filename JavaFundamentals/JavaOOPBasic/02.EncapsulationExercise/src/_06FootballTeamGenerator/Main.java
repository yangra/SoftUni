package _06FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new HashMap<>();
        while (true) {
            String[] command = reader.readLine().split(";");
            if ("end".equalsIgnoreCase(command[0])) {
                break;
            }

            switch (command[0].toLowerCase()) {
                case "team":
                    try {
                        Team team = new Team(command[1]);
                        teams.put(team.getName(), team);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "add":
                    if (!teams.containsKey(command[1])) {
                        System.out.printf("Team %s does not exist.\n", command[1]);
                        break;
                    }
                    try {
                        Player player = new Player(command[2], Integer.parseInt(command[3]), Integer.parseInt(command[4]),
                                Integer.parseInt(command[5]), Integer.parseInt(command[6]), Integer.parseInt(command[7]));
                        teams.get(command[1]).addPlayer(player);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "remove":
                    if (!teams.containsKey(command[1])) {
                        System.out.printf("Team %s does not exist.\n", command[1]);
                        break;
                    }
                    try {
                        teams.get(command[1]).removePlayer(command[2]);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "rating":
                    if (!teams.containsKey(command[1])) {
                        System.out.printf("Team %s does not exist.\n", command[1]);
                        break;
                    }
                    Team team = teams.get(command[1]);
                    System.out.printf("%s - %.0f\n", team.getName(), team.getRating());
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
}
