package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public class Wizard extends HeroImpl {


    public Wizard(String name) {
        super(name);
        super.setStrength(Config.WIZARD_BASE_STRENGTH);
        super.setDexterity(Config.WIZARD_BASE_DEXTERITY);
        super.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
        this.setHealth(super.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence()*5) +super.getDexterity();
    }
}
