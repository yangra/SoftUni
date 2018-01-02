package BoatSimulator.contracts;

import BoatSimulator.database.Database;
import BoatSimulator.enumeration.EngineType;
import BoatSimulator.exceptions.*;

public interface BoatSimulatorController {

    String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException;

    String createRowBoat(String model, int weight, int oars) throws DuplicateModelException;

    String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException;

    String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistingModelException, DuplicateModelException;

    String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistingModelException, DuplicateModelException;

    String openRace(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorboats) throws RaceAlreadyExistsException;

    String signUpBoat(String model) throws NonExistingModelException, DuplicateModelException, NoSetRaceException;

    String startRace() throws InsufficientContestantsException, NoSetRaceException;

    String getStatistics() throws NoSetRaceException;
}
