package BoatSimulator.factories;

import BoatSimulator.models.boat_engines.BoatEngine;
import BoatSimulator.models.boat_engines.JetEngine;
import BoatSimulator.models.boat_engines.SternDriveEngine;

public final class BoatEngineFactory {
    private BoatEngineFactory() {
    }

    public static BoatEngine createJetEngine(String model, int horsepower, int displacement){
        return  new JetEngine(model,horsepower,displacement);
    }

    public static BoatEngine createSternDriveEngine(String model, int horsepower, int displacement){
        return  new SternDriveEngine(model,horsepower,displacement);
    }
}
