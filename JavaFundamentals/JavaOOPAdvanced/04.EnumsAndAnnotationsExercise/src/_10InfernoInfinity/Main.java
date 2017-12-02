package _10InfernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Weapon> weapons = new LinkedHashMap<>();
        while (true) {
            String[] command = reader.readLine().split(";");
            if ("END".equalsIgnoreCase(command[0])) {
                break;
            }

            switch (command[0]) {
                case "Add":
                    Weapon weapon = weapons.get(command[1]);
                    Gem gem = Gem.valueOf(command[3]);
                    weapon.addGem(gem, Integer.parseInt(command[2]));
                    break;
                case "Remove":
                    weapon = weapons.get(command[1]);
                    weapon.removeGem(Integer.parseInt(command[2]));
                    break;
                case "Create":
                    weapon = null;
                    switch (command[1].toLowerCase()) {
                        case "axe":
                            weapon = WeaponFactory.makeAxe(command[2]);
                            break;
                        case "knife":
                            weapon = WeaponFactory.makeKnife(command[2]);
                            break;
                        case "sword":
                            weapon = WeaponFactory.makeSword(command[2]);
                            break;
                    }
                    weapons.putIfAbsent(command[2], weapon);
                    break;
                case "Print":
                    weapon = weapons.get(command[1]);
                    System.out.println(weapon);
                    break;
            }
        }

//        for (Weapon weapon : weapons.values()) {
//            System.out.println(weapon);
//        }
    }
}
