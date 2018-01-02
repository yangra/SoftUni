package BoatSimulator.models.boat_engines;

import BoatSimulator.utility.Constants;
import BoatSimulator.utility.Validator;

public abstract class BaseBoatEngine implements BoatEngine {

    private String model;
    private int horsepower;
    private int displacement;
    private int output;

    public BaseBoatEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
        this.setOutput(calculateOutput(this.horsepower, this.displacement));
    }

    @Override
    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    private void setHorsepower(int horsepower) {
        Validator.ValidatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) {
        Validator.ValidatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }

    @Override
    public int getOutput() {
        return this.output;
    }

    private void setOutput(int output) {
        this.output = output;
    }

    protected abstract int calculateOutput(int horsepower, int displacement);
}
