package _08MilitaryElite.soldiers;


import _08MilitaryElite.interfaces.ICommando;
import _08MilitaryElite.interfaces.IMission;

import java.util.*;

public class Commando extends SpecializedSoldier implements ICommando {
    private List<IMission> missions;

    public Commando(String id, String firstName, String lastName, double salary, String corps, List<IMission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.missions = missions;
    }

    @Override
    public List<IMission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(super.getCorps()).append(System.lineSeparator());
        sb.append("Missions:").append(System.lineSeparator());
        int count = 0;
        for (IMission imission : this.missions) {
            sb.append("  ").append(imission.toString()).append(System.lineSeparator());
            count++;
        }

        return sb.toString();
    }
}
