package BoatSimulator.models.boats;

import BoatSimulator.contracts.Race;
import BoatSimulator.utility.Constants;

public class SailBoat extends BaseBoat {
    private int sailEfficiency;
    private Boolean isSailboat;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }


    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public boolean hasMotor() {
        return false;
    }

    @Override
    public double calculateSpeed(Race race) {
        return (race.getWindSpeed() * (this.sailEfficiency / 100.0)) -
                super.getWeight() + (race.getOceanCurrentSpeed() / 2.0);
    }
}
