package _05KingsGambitExtended.models;

import _05KingsGambitExtended.interfaces.Observer;

public abstract class KingsUnit implements Observer {
    private String name;
    private int health;


    protected KingsUnit(String name, int health) {
        this.name = name;
        this.health = health;
    }

    protected String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void takeHit() {
        this.health -= 1;

    }



}
