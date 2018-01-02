package BoatSimulator.models.boats;

import BoatSimulator.contracts.Race;
import BoatSimulator.models.boat_engines.BoatEngine;

import java.util.ArrayList;
import java.util.List;

public class PowerBoat extends BaseBoat{
    private List<BoatEngine> engines;


    public PowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine) {
        super(model, weight);
        this.engines = new ArrayList<>();
        this.engines.add(firstEngine);
        this.engines.add(secondEngine);
    }

    @Override
    public boolean hasMotor() {
        return true;
    }

    @Override
    public double calculateSpeed(Race race) {
        return (engines.get(0).getOutput() + engines.get(1).getOutput()) -
                super.getWeight() + (race.getOceanCurrentSpeed()/ 5.0);
    }


}
