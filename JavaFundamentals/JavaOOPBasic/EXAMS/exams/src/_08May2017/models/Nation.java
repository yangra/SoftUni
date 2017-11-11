package _08May2017.models;

import _08May2017.models.benders.Bender;
import _08May2017.models.monuments.Monument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Nation {
    private List<Bender> benders;
    private List<Monument> monuments;

    public Nation() {
        this.benders = new ArrayList<>();
        this.monuments = new ArrayList<>();
    }

    public void addBender(Bender bender) {
        this.benders.add(bender);
    }

    public void addMonument(Monument monument) {
        this.monuments.add(monument);
    }

    public List<Bender> getBenders() {
        return Collections.unmodifiableList(this.benders);
    }

    public List<Monument> getMonuments() {
        return Collections.unmodifiableList(this.monuments);
    }

    public void clearBenders() {
        this.benders.clear();
    }

    public void clearMonumnets() {
        this.monuments.clear();
    }

    public double getTotalPower() {
        double totalPower = 0.0;

        for (Bender bender : benders) {
            totalPower += bender.getTotalPower();
        }
        Long totalAffinity = 0L;
        for (Monument monument : monuments) {
            totalAffinity += monument.getAffinity();
        }

        totalPower += (totalPower / 100) * totalAffinity;

        return totalPower;
    }
}
