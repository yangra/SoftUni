package BoatSimulator.models.boats;

import BoatSimulator.contracts.Race;
import BoatSimulator.utility.Constants;
import BoatSimulator.utility.Validator;

public abstract class BaseBoat implements Boat {
    private String model;
    private int weight;

    public BaseBoat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    @Override
    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    public int getWeight() {
        return this.weight;
    }

    private void setWeight(int weight) {
        Validator.ValidatePropertyValue(weight, "Weight");
        this.weight = weight;
    }
}
