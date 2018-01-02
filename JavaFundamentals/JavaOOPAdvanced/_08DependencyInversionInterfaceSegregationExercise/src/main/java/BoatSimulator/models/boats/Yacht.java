package BoatSimulator.models.boats;

import BoatSimulator.contracts.Race;
import BoatSimulator.models.boat_engines.BoatEngine;
import BoatSimulator.utility.Validator;

public class Yacht extends BaseBoat {
    private BoatEngine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, BoatEngine engine, int cargoWeight) {
        super(model, weight);
        this.setCargoWeight(cargoWeight);
        this.engine = engine;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public boolean hasMotor() {
        return true;
    }

    @Override
    public double calculateSpeed(Race race) {
        return this.engine.getOutput() - (super.getWeight() + this.cargoWeight) + (race.getOceanCurrentSpeed()/ 2.0);
    }
}
