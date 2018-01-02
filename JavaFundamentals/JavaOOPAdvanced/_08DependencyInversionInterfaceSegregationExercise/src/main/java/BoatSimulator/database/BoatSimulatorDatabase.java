package BoatSimulator.database;


import BoatSimulator.contracts.Repository;
import BoatSimulator.models.boat_engines.BoatEngine;
import BoatSimulator.models.boats.Boat;


public class BoatSimulatorDatabase implements Database{
    Repository<Boat> boats;
    Repository<BoatEngine> engines;

    public BoatSimulatorDatabase(Repository<Boat> boats, Repository<BoatEngine> engines) {
        this.boats = boats;
        this.engines = engines;
    }

    @Override
    public Repository<Boat> getBoats() {
        return this.boats;
    }

    @Override
    public Repository<BoatEngine> getEngines() {
        return this.engines;
    }

}
