package _08MilitaryElite;

import _08MilitaryElite.interfaces.*;
import _08MilitaryElite.soldiers.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, ISoldier> soldiers = new LinkedHashMap<>();
        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if ("end".equalsIgnoreCase(input[0])) {
                break;
            }

            String id = input[1];
            String firstName = input[2];
            String lastName = input[3];

            switch (input[0]) {
                case "Private":
                    soldiers.putIfAbsent(id, new Private(id, firstName, lastName, Double.parseDouble(input[4])));
                    break;
                case "LeutenantGeneral":
                    List<IPrivate> privates = parsePrivates(input, soldiers);
                    soldiers.putIfAbsent(id, new LeutenantGeneral(id, firstName, lastName, Double.parseDouble(input[4]), privates));
                    break;
                case "Engineer":
                    List<IRepair> repairs = parseRepairs(input);
                    ISpecializedSoldier engineer = new Engineer(id, firstName, lastName, Double.parseDouble(input[4]), input[5], repairs);
                    if (engineer.getCorps() != null) {
                        soldiers.putIfAbsent(id, engineer);
                    }
                    break;
                case "Commando":
                    List<IMission> missions = parseMissions(input);
                    ISpecializedSoldier commando = new Commando(id, firstName, lastName, Double.parseDouble(input[4]), input[5], missions);
                    if (commando.getCorps() != null) {
                        soldiers.putIfAbsent(id, commando);
                    }

                    break;
                case "Spy":
                    soldiers.putIfAbsent(id, new Spy(id, firstName, lastName, input[4]));
                    break;

            }
        }

        for (ISoldier iSoldier : soldiers.values()) {
            System.out.println(iSoldier.toString().trim());
        }
    }

    private static List<IRepair> parseRepairs(String[] input) {
        List<IRepair> repairs = new ArrayList<>();
        for (int i = 6; i < input.length; i += 2) {
            IRepair repair = new Repair(input[i], Integer.parseInt(input[i + 1]));
            repairs.add(repair);
        }
        return repairs;
    }

    private static List<IMission> parseMissions(String[] input) {
        List<IMission> missions = new ArrayList<>();
        for (int i = 6; i < input.length; i += 2) {
            IMission mission = new Mission(input[i], input[i + 1]);
            if (mission.getState() != null) {
                missions.add(mission);
            }
        }
        return missions;
    }


    private static List<IPrivate> parsePrivates(String[] input, Map<String, ISoldier> soldiers) {
        List<IPrivate> privates = new ArrayList<>();
        for (int i = 5; i < input.length; i++) {
            ISoldier soldier = soldiers.get(input[i]);
            privates.add((IPrivate) soldier);
        }
        return privates;
    }
}
