package BoatSimulator.contracts;

import BoatSimulator.exceptions.DuplicateModelException;
import BoatSimulator.models.boats.Boat;

import java.util.List;

public interface Race
{
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    boolean allowsMotorBoats();

    void addParticipant(Boat boat) throws DuplicateModelException;

    List<Boat> getParticipants();
}
