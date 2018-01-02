package BoatSimulator.factories;

import BoatSimulator.models.boat_engines.BoatEngine;
import BoatSimulator.models.boats.*;

public final class BoatFactory {
    private BoatFactory() {
    }

    public static Boat createPowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine) {
        return new PowerBoat(model, weight, firstEngine, secondEngine);
    }

    public static Boat createSailBoat(String model, int weight, int sailEfficiency) {
        return new SailBoat(model, weight, sailEfficiency);
    }

    public static Boat createRowBoat(String model, int weight, int oars) {
        return new RowBoat(model, weight, oars);
    }

    public static Boat createYacht(String model, int weight,BoatEngine engine, int cargoWeight) {
        return new Yacht(model, weight, engine, cargoWeight);
    }
}
