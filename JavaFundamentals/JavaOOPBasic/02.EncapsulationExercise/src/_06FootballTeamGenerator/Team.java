package _06FootballTeamGenerator;

import java.util.HashMap;
import java.util.Map;

class Team {
    private String name;
    private Map<String, Player> players;

    Team(String name) {
        this.setName(name);
        this.players = new HashMap<>();
    }

    String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    void addPlayer(Player player) {
        players.put(player.getName(), player);
    }

    void removePlayer(String player) {
        if (!this.players.containsKey(player)) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player, this.name));
        }

        this.players.remove(player);
    }

    double getRating() {
        if (this.players.size() > 0) {
            return this.players.entrySet().stream()
                    .mapToDouble(me -> me.getValue().getOverallSkill()).average().getAsDouble();
        }
        return 0;
    }
}
