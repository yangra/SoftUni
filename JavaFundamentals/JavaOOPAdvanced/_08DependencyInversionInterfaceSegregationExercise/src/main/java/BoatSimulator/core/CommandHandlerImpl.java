package BoatSimulator.core;

import BoatSimulator.utility.Constants;
import BoatSimulator.contracts.BoatSimulatorController;
import BoatSimulator.enumeration.EngineType;
import BoatSimulator.exceptions.*;

import java.util.List;

public class CommandHandlerImpl implements BoatSimulator.contracts.CommandHandler {

    private BoatSimulatorController controller;

    public CommandHandlerImpl(BoatSimulatorController controller) {
        this.controller = controller;
    }

    public String executeCommand(String[] parameters) throws DuplicateModelException, NonExistingModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        switch (parameters[0]) {
            case "CreateBoatEngine":
                EngineType engineType;
                if (parameters[4].equals("Jet")) {
                    return this.controller.createBoatEngine(
                            parameters[1],
                            Integer.parseInt(parameters[2]),
                            Integer.parseInt(parameters[3]),
                            EngineType.valueOf(parameters[4].toUpperCase()));
                } else if (parameters[4].equals("Sterndrive")) {
                    return this.controller.createBoatEngine(
                            parameters[1],
                            Integer.parseInt(parameters[2]),
                            Integer.parseInt(parameters[3]),
                            EngineType.valueOf(parameters[4].toUpperCase()));
                }

                throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE_MESSAGE);

            case "CreateRowBoat":
                return this.controller.createRowBoat(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        Integer.parseInt(parameters[3]));
            case "CreateSailBoat":
                return this.controller.createSailBoat(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        Integer.parseInt(parameters[3]));
            case "CreatePowerBoat":
                return this.controller.createPowerBoat(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        parameters[3],
                        parameters[4]);
            case "CreateYacht":
                return this.controller.createYacht(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        parameters[3],
                        Integer.parseInt(parameters[4]));
            case "OpenRace":
                return this.controller.openRace(
                        Integer.parseInt(parameters[1]),
                        Integer.parseInt(parameters[2]),
                        Integer.parseInt(parameters[3]),
                        Boolean.parseBoolean(parameters[4]));
            case "SignUpBoat":
                return this.controller.signUpBoat(parameters[1]);
            case "StartRace":
                return this.controller.startRace();
            case "GetStatistic":
                return this.controller.getStatistics();
            default:
                throw new IllegalArgumentException("Invalid command");
        }
    }
}
