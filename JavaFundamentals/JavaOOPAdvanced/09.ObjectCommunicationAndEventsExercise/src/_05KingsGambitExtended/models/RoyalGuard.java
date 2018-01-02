package _05KingsGambitExtended.models;

import _05KingsGambitExtended.interfaces.Observer;

public class RoyalGuard extends KingsUnit implements Observer {

    public static final int HEALTH = 3;

    public RoyalGuard(String name) {
        super(name, HEALTH);
    }


    @Override
    public void update() {
        System.out.println("Royal Guard " + super.getName() + " is defending!");
    }


}
