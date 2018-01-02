package BoatSimulator.database;

import BoatSimulator.contracts.Repository;
import BoatSimulator.models.boat_engines.BoatEngine;
import BoatSimulator.models.boats.Boat;

public interface Database {

    Repository<Boat> getBoats();

    Repository<BoatEngine> getEngines();
}

