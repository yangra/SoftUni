package _12March2017Copy.factories;

import _12March2017Copy.entities.races.CasualRace;
import _12March2017Copy.entities.races.DragRace;
import _12March2017Copy.entities.races.DriftRace;
import _12March2017Copy.entities.races.Race;

public final class RaceFactory {

    private RaceFactory(){}

    public static Race makeCasualRace(int length, String route, int prizePool){
        return new CasualRace(length,route,prizePool);
    }

    public static Race makeDragRace(int length, String route, int prizePool){
        return new DragRace(length,route,prizePool);
    }

    public static Race makeDriftRace(int length, String route, int prizePool){
        return new DriftRace(length,route,prizePool);
    }
}
