package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BossFight implements Action {

    private List<Targetable> participants;

    public BossFight() {
        this.participants = new ArrayList<>();
    }

    @Override
    public String executeAction(List<Targetable> participants) {
        String error = "There should be at least 1 participant for boss fight!";
        if (participants.size() < 1) {
            return error;
        }

        StringBuilder sb = new StringBuilder();

        Targetable boss = participants.get(0);
        for (int i = 1; i < participants.size(); i++) {
            Targetable participant = participants.get(i);
            this.participants.add(participant);
        }

        int victoryIndex = 0;
        whileBossIsAlive:
        while (boss.isAlive()) {
            if (this.participants.stream().filter(Targetable::isAlive).count() == 0) {
                boss.levelUp();
                sb.append("Boss has slain them all!");
                break;
            }

            for (int i = 0; i < this.participants.size(); i++) {
                if (this.participants.get(i).isAlive()) {
                    this.participants.get(i).attack(boss);
                    if (boss.isAlive()) {
                        boss.attack(this.participants.get(i));
                    } else {
                        victoryIndex = i;
                        break whileBossIsAlive;
                    }
                } else {
                    continue;
                }
            }
        }

        if (!boss.isAlive()) {
            for (int i = 0; i < this.participants.size(); i++) {
                if (this.participants.get(i).isAlive()) {
                    if (i != victoryIndex) {
                        this.participants.get(i).levelUp();
                    }
                    this.participants.get(i).receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
                }
            }
            sb.append(String.format("Boss has been slain by:", boss.getName())).append(System.lineSeparator());
            List<Targetable> sorted = this.participants.stream().sorted(Comparator.comparing(Targetable::getName)).collect(Collectors.toList());
            for (Targetable targetable : sorted) {
                sb.append(String.format("%s", targetable.toString())).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}