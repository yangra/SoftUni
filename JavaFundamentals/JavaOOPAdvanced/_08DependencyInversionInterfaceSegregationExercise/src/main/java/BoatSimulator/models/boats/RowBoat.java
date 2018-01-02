package BoatSimulator.models.boats;

import BoatSimulator.contracts.Race;
import BoatSimulator.utility.Validator;

public class RowBoat extends BaseBoat{
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public boolean hasMotor() {
        return false;
    }

    @Override
    public double calculateSpeed(Race race) {
        return (this.oars * 100) - super.getWeight() + race.getOceanCurrentSpeed();

    }
}
