package BoatSimulator.factories;

import BoatSimulator.contracts.Race;
import BoatSimulator.models.RaceImpl;


public final class RaceFactory {
    private RaceFactory() {
    }

    public static Race createRace(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorBoats){
        return  new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorBoats);
    }
}
