package _02KingsGambit;

import _02KingsGambit.interfaces.Observer;

public class Footman implements Observer {
    private String name;

    public Footman(String name) {
        this.name = name;

    }

    @Override
    public void update() {
        System.out.println("Footman " + this.name + " is panicking!");
    }


}
