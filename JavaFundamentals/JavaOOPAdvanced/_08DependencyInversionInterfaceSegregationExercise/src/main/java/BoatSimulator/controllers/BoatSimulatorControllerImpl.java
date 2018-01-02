package BoatSimulator.controllers;

import BoatSimulator.contracts.BoatSimulatorController;
import BoatSimulator.database.Database;
import BoatSimulator.factories.BoatEngineFactory;
import BoatSimulator.factories.BoatFactory;
import BoatSimulator.factories.RaceFactory;
import BoatSimulator.models.boat_engines.BoatEngine;
import BoatSimulator.models.boats.Boat;
import BoatSimulator.utility.Constants;
import BoatSimulator.contracts.Race;
import BoatSimulator.enumeration.EngineType;
import BoatSimulator.exceptions.*;

import java.util.*;
import java.util.stream.Collectors;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {

    private static String[] PLACEMENT = new String[]{"First", "Second", "Third"};

    private Database database;
    private Race currentRace;

    public BoatSimulatorControllerImpl(Database database) {
        this.database = database;
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        BoatEngine engine = null;
        switch (engineType) {
            case JET:
                engine = BoatEngineFactory.createJetEngine(model, horsepower, displacement);
                break;
            case STERNDRIVE:
                engine = BoatEngineFactory.createSternDriveEngine(model, horsepower, displacement);
                break;
        }

        this.database.getEngines().add(engine);
        StringBuilder sb = new StringBuilder();
        sb.append("Engine model ").append(model).append(" with ").append(horsepower).append(" HP and displacement ")
                .append(displacement).append(" cm3 created successfully.");
        return sb.toString();
    }

    @Override
    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat rowBoat = BoatFactory.createRowBoat(model, weight, oars);
        this.database.getBoats().add(rowBoat);
        StringBuilder sb = new StringBuilder();
        sb.append("Row boat with model ").append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat sailBoat = BoatFactory.createSailBoat(model, weight, sailEfficiency);
        this.database.getBoats().add(sailBoat);
        StringBuilder sb = new StringBuilder();
        sb.append("Sail boat with model ").append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistingModelException, DuplicateModelException {
        BoatEngine firstEngine = this.database.getEngines().getByModel(firstEngineModel);
        BoatEngine secondEngine = this.database.getEngines().getByModel(secondEngineModel);
        Boat powerBoat = BoatFactory.createPowerBoat(model, weight, firstEngine, secondEngine);
        this.database.getBoats().add(powerBoat);
        StringBuilder sb = new StringBuilder();
        sb.append("Power boat with model ").append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistingModelException, DuplicateModelException {
        BoatEngine engine = this.database.getEngines().getByModel(engineModel);
        Boat yacht = BoatFactory.createYacht(model, weight, engine, cargoWeight);
        this.database.getBoats().add(yacht);
        StringBuilder sb = new StringBuilder();
        sb.append("Yacht with model ").append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorBoats)
            throws RaceAlreadyExistsException {
        this.ValidateRaceIsEmpty();
        this.currentRace = RaceFactory.createRace(distance, windSpeed, oceanCurrentSpeed, allowsMotorBoats);
        StringBuilder sb = new StringBuilder();
        sb.append("A new race with distance ").append(distance).append(" meters, wind speed ").append(windSpeed)
                .append(" m/s and ocean current speed ").append(oceanCurrentSpeed).append(" m/s has been set.");
        return sb.toString();
    }

    @Override
    public String signUpBoat(String model)
            throws NonExistingModelException, DuplicateModelException, NoSetRaceException {
        this.ValidateRaceIsSet();
        Boat boat = this.database.getBoats().getByModel(model);
        if (!this.currentRace.allowsMotorBoats() && boat.hasMotor()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }

        this.currentRace.addParticipant(boat);

        StringBuilder sb = new StringBuilder();
        sb.append("Boat with model ").append(model).append(" has signed up for the current Race.");
        return sb.toString();
    }

    @Override
    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.ValidateRaceIsSet();
        List<Boat> participants = this.currentRace.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }

        Comparator<Boat> rankComparator = (boat1, boat2) -> {
            double speed1 = boat1.calculateSpeed(this.currentRace);
            double speed2 = boat2.calculateSpeed(this.currentRace);
            if (speed1 <= 0 && speed2 <= 0) {
                return 0;
            }

            return Double.compare(speed2, speed1);
        };

        List<Boat> winners = participants.stream().sorted(rankComparator).limit(3).collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        int position = 0;
        for (Boat winner : winners) {
            result.append(String.format("%s place: %s Model: %s Time: %s",
                    PLACEMENT[position++], winner.getClass().getSimpleName(), winner.getModel(),
                    winner.calculateSpeed(this.currentRace) > 0.0 ?
                            String.format("%.2f sec", currentRace.getDistance() / winner.calculateSpeed(this.currentRace)) :
                            "Did not finish!")).append(System.lineSeparator());

        }

        this.currentRace = null;

        return result.toString().trim();
    }

    @Override
    public String getStatistics() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }

        List<Boat> participants = this.currentRace.getParticipants();
        Map<String, List<Boat>> participantsByBoatType = participants.stream()
                .collect(Collectors.groupingBy(p -> p.getClass().getSimpleName()));
        int totalParticipants = participantsByBoatType.values().stream().mapToInt(List::size).sum();

        StringBuilder sb = new StringBuilder();
        participantsByBoatType.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach((e) -> {
                    sb.append(String.format("%s -> %.2f", e.getKey(), 100.0 * e.getValue().size() / totalParticipants));
                    sb.append("%").append(System.lineSeparator());
                });
        return sb.toString().trim();
    }

    private void ValidateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void ValidateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }
}
