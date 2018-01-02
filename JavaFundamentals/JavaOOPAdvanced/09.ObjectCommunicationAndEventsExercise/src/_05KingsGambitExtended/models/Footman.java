package _05KingsGambitExtended.models;

import _05KingsGambitExtended.interfaces.Observer;

public class Footman extends KingsUnit implements Observer {


    public static final int HEALTH = 2;

    public Footman(String name) {
        super(name, HEALTH);

    }

    @Override
    public void update() {
        System.out.println("Footman " + super.getName() + " is panicking!");
    }


}
