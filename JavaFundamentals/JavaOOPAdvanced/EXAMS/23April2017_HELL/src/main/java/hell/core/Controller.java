package hell.core;

import hell.factories.HeroFactory;
import hell.factories.InventoryFactory;
import hell.factories.ItemFactory;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Controller {

    private List<Hero> heroes;

    public Controller() {
        this.heroes = new ArrayList<>();
    }

    String heroCommand(List<String> args) {
        switch (args.get(1)) {
            case "Barbarian":
                Hero barbarian = HeroFactory.createBarbarian(args.get(0));
                this.heroes.add(barbarian);
                break;
            case "Assassin":
                Hero assassin = HeroFactory.createAssassin(args.get(0));
                this.heroes.add(assassin);
                break;
            case "Wizard":
                Hero wizard = HeroFactory.createWizard(args.get(0));
                this.heroes.add(wizard);
                break;
        }

        return String.format("Created %s - %s", args.get(1), args.get(0));
    }

    String itemCommand(List<String> args) {
        Item item = ItemFactory.createCommonItem(args.get(0),
                Integer.parseInt(args.get(2)),
                Integer.parseInt(args.get(3)),
                Integer.parseInt(args.get(4)),
                Integer.parseInt(args.get(5)),
                Integer.parseInt(args.get(6)));
        for (Hero hero : this.heroes) {
            if (hero.getName().equals(args.get(1))) {
                hero.addItem(item);
            }
        }

        return String.format("Added item - %s to Hero - %s", args.get(0), args.get(1));
    }

    String recipeCommand(List<String> args) {
        Recipe recipe = ItemFactory.createRecipeItem(args.get(0),
                Integer.parseInt(args.get(2)),
                Integer.parseInt(args.get(3)),
                Integer.parseInt(args.get(4)),
                Integer.parseInt(args.get(5)),
                Integer.parseInt(args.get(6)),
                args.subList(7, args.size()));
        for (Hero hero : this.heroes) {
            if (hero.getName().equals(args.get(1))) {
                hero.addRecipe(recipe);
            }
        }

        return String.format("Added recipe - %s to Hero - %s", args.get(0), args.get(1));
    }

    String inspectCommand(List<String> args) {
        Hero hero = null;
        for (Hero heroe : this.heroes) {
            if (heroe.getName().equals(args.get(0))) {
                hero = heroe;
            }
        }

        return hero.toString();
    }

    //    1. Barbarian: Ivan
//###HitPoints: 450
//            ###Damage: 200
//            ###Strength: 115
//            ###Agility: 35
//            ###Intelligence: 20
//            ###Items: Spear
    public String quitCommand() {

        Comparator<Hero> sortHeroes = (hero1, hero2) -> {
            long op1 = hero1.getStrength() + hero1.getAgility() + hero1.getIntelligence();
            long op2 = hero2.getStrength() + hero2.getAgility() + hero2.getIntelligence();
            if (op1 == op2) {
                long secOp1 = hero1.getHitPoints() + hero1.getDamage();
                long secOp2 = hero2.getHitPoints() + hero2.getDamage();
                return Long.compare(secOp2, secOp1);
            }

            return Long.compare(op2, op1);
        };
        List<Hero> sorted = this.heroes.stream().sorted(sortHeroes).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (Hero hero : sorted) {
            sb.append(counter++).append(". ").append(hero.getClass().getSimpleName()).append(": ").append(hero.getName()).append(System.lineSeparator())
                    .append("###HitPoints: ").append(hero.getHitPoints()).append(System.lineSeparator())
                    .append("###Damage: ").append(hero.getDamage()).append(System.lineSeparator())
                    .append("###Strength: ").append(hero.getStrength()).append(System.lineSeparator())
                    .append("###Agility: ").append(hero.getAgility()).append(System.lineSeparator())
                    .append("###Intelligence: ").append(hero.getIntelligence()).append(System.lineSeparator())
                    .append("###Items: ");
            if (hero.getItems().size() > 0) {
                sb.append(hero.getItems().toString().replaceAll("[\\]\\[]", "")).append(System.lineSeparator());
            } else {
                sb.append("None").append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
