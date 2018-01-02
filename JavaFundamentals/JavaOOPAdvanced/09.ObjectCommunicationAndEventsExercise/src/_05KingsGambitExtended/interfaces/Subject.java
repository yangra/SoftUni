package _05KingsGambitExtended.interfaces;

public interface Subject{

    public void register(Observer observer);

    public void unregister(Observer observer);

    public void notifyObservers();
}
