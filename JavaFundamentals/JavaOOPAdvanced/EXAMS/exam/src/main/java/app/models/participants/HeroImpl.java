package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public abstract class HeroImpl implements Hero {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;

    private double health;
    private String name;
    private boolean isAlive;
    private double gold;

//    protected HeroImpl() {
//        this.isAlive = true;
//        this.level = 1;
//        this.gold = Config.HERO_START_GOLD;
//
//    }

    protected HeroImpl(String name) {
        this.name = name;
        this.isAlive = true;
        this.level = 1;
        this.gold = Config.HERO_START_GOLD;
    }

    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()) {
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }

//    public double getReward(){
//        this.gold = 0;
//        return this.gold;
//    }

    public void receiveReward(double reward) {
        this.gold += reward;
    }

    public void takeDamage(double damage) {
        this.setHealth(this.health - damage);
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
        this.gold = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double getDamage();

    public double getGold() {
        return this.gold;
    }

    public boolean isAlive() {
        return this.health>0;
    }

    public void levelUp() {
        this.setStrength(this.getStrength() * 2);
        this.setDexterity(this.getDexterity() * 2);
        this.setIntelligence(this.getIntelligence() * 2);
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.level += 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.gold));

        return sb.toString();
    }
}
