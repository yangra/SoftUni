package _12March2017Copy.entities.races;

import _12March2017Copy.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    protected Race(int length, String route, int prizePool) {
        this.setLength(length);
        this.setRoute(route);
        this.setPrizePool(prizePool);
        this.participants = new ArrayList<>();
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    protected int getLength() {
        return this.length;
    }

    protected String getRoute() {
        return this.route;
    }

    protected int getPrizePool() {
        return this.prizePool;
    }

    private void setLength(int length) {
        this.length = length;
    }

    private void setRoute(String route) {
        this.route = route;
    }

    private void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public void addParticipant(Car car) {
        this.participants.add(car);
    }

    public abstract String start();

}
