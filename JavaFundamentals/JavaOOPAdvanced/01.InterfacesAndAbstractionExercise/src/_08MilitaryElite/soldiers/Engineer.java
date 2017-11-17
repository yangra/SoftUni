package _08MilitaryElite.soldiers;


import _08MilitaryElite.interfaces.IEngineer;
import _08MilitaryElite.interfaces.IRepair;

import java.util.*;

public class Engineer extends SpecializedSoldier implements IEngineer {
    private List<IRepair> repairs;

    public Engineer(String id, String firstName, String lastName, double salary, String corps, List<IRepair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = repairs;
    }

    @Override
    public List<IRepair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(super.getCorps()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());
        int count = 0;
        for (IRepair irepair : this.repairs) {
            sb.append("  ").append(irepair.toString()).append(System.lineSeparator());
            count++;
        }

        return sb.toString();
    }
}
