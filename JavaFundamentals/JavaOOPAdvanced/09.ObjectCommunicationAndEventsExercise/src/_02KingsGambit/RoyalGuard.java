package _02KingsGambit;

import _02KingsGambit.interfaces.Observer;

public class RoyalGuard implements Observer {
    private String name;


    public RoyalGuard(String name) {
        this.name = name;
    }


    @Override
    public void update() {
        System.out.println("Royal Guard " + this.name + " is defending!");
    }


}
