package hell.factories;


import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.interfaces.Hero;

public final class HeroFactory {
    private HeroFactory() {
    }

    public static Hero createBarbarian(String name) {
        return new Barbarian(name);
    }

    public static Hero createAssassin(String name) {
        return new Assassin(name);
    }

    public static Hero createWizard(String name) {
        return new Wizard(name);
    }
}
