package BoatSimulator.models.boat_engines;

import BoatSimulator.contracts.Modelable;

public class JetEngine extends BaseBoatEngine implements Modelable {
    private static final int OUTPUT_MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    protected int calculateOutput(int horsepower, int displacement) {
        return (horsepower * OUTPUT_MULTIPLIER) + displacement;
    }
}
