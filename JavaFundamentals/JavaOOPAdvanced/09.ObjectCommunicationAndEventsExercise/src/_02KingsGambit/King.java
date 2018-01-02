package _02KingsGambit;

import _02KingsGambit.interfaces.Attackable;
import _02KingsGambit.interfaces.AttackableSubject;
import _02KingsGambit.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class King implements AttackableSubject {

    private String name;
    private List<Observer> observers;

    public King(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
    }

    @Override
    public void respondToAttack() {
        System.out.println("King "+ this.name +" is under attack!");
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
