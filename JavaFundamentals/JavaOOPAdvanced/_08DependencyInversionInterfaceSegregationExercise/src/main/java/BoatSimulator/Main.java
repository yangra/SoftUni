package BoatSimulator;

import BoatSimulator.contracts.BoatSimulatorController;
import BoatSimulator.contracts.CommandHandler;
import BoatSimulator.contracts.Repository;
import BoatSimulator.controllers.BoatSimulatorControllerImpl;
import BoatSimulator.core.CommandHandlerImpl;
import BoatSimulator.core.Engine;
import BoatSimulator.database.BoatSimulatorDatabase;
import BoatSimulator.database.CrudRepository;
import BoatSimulator.database.Database;
import BoatSimulator.io.ConsoleInputReader;
import BoatSimulator.io.ConsoleOutputWriter;
import BoatSimulator.io.InputReader;
import BoatSimulator.io.OutputWriter;
import BoatSimulator.models.boat_engines.BoatEngine;
import BoatSimulator.models.boats.Boat;

public class Main {
    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();
        Repository<Boat> boatRepository = new CrudRepository<>();
        Repository<BoatEngine> boatEngineRepository = new CrudRepository<>();
        Database database = new BoatSimulatorDatabase(boatRepository,boatEngineRepository);
        BoatSimulatorController controller = new BoatSimulatorControllerImpl(database);
        CommandHandler commandHandler = new CommandHandlerImpl(controller);
        Engine engine = new Engine(inputReader, outputWriter, commandHandler);

        engine.run();
    }
}
