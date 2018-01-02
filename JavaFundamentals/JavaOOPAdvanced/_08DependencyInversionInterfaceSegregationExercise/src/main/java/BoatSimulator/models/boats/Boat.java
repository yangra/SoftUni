package BoatSimulator.models.boats;

import BoatSimulator.contracts.Modelable;
import BoatSimulator.contracts.Race;

public interface Boat extends Modelable {

    boolean hasMotor();

    double calculateSpeed(Race race);
}
