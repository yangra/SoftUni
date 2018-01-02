package _02KingsGambit.interfaces;

public interface Subject{

    public void register(Observer observer);

    public void unregister(Observer observer);

    public void notifyObservers();
}
