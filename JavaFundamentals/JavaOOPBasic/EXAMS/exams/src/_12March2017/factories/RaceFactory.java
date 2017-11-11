package _12March2017.factories;

import _12March2017.entities.races.*;

public final class RaceFactory {

    private RaceFactory() { }

    public static Race makeCasualRace(int length, String route, int prizePool){
        return new CasualRace(length,route,prizePool);
    }

    public static Race makeDragRace(int length, String route, int prizePool){
        return new DragRace(length,route,prizePool);
    }

    public static Race makeDriftRace(int length, String route, int prizePool){
        return new DriftRace(length,route,prizePool);
    }

    public static Race makeTimeLimitRace(int length, String route, int prizePool, int goldTime){
        return new TimeLimitRace(length,route,prizePool, goldTime);
    }
    public static Race makeCircuitRace(int length, String route, int prizePool, int laps){
        return new CircuitRace(length,route,prizePool,laps);
    }
}
