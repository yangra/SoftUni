package _13CreateCustomClassAnnotation;

import _13CreateCustomClassAnnotation.annotations.CustomAnnotation;
import _13CreateCustomClassAnnotation.enums.Gem;

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
                case "Create":
                    Weapon weapon = null;
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
                case "Add":
                    weapon = weapons.get(command[1]);
                    Gem gem = Gem.valueOf(command[3]);
                    weapon.addGem(gem, Integer.parseInt(command[2]));
                    break;
                case "Remove":
                    weapon = weapons.get(command[1]);
                    weapon.removeGem(Integer.parseInt(command[2]));
                    break;
                case "Compare":
                    Weapon weapon1 = weapons.get(command[1]);
                    Weapon weapon2 = weapons.get(command[2]);
                    weapon = weapon1.compare(weapon2);
                    System.out.println(weapon.print());
                    break;
                case "Print":
                    weapon = weapons.get(command[1]);
                    System.out.println(weapon);
                    break;
                case "Author":
                    CustomAnnotation annotation = WeaponImpl.class.getAnnotation(CustomAnnotation.class);
                    System.out.printf("Author: %s\n", annotation.author());
                    break;
                case "Revision":
                    annotation = WeaponImpl.class.getAnnotation(CustomAnnotation.class);
                    System.out.printf("Revision: %d\n", annotation.revision());
                    break;
                case "Description":
                    annotation = WeaponImpl.class.getAnnotation(CustomAnnotation.class);
                    System.out.printf("Class description: %s\n", annotation.description());
                    break;
                case "Reviewers":
                    annotation = WeaponImpl.class.getAnnotation(CustomAnnotation.class);
                    System.out.printf("Reviewers: %s\n",String.join(", ",annotation.reviewers()));
                    break;
            }
        }
    }
}
