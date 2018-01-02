package cresla.entities.reactors;

import cresla.interfaces.Container;

public class HeatReactor extends ReactorImpl {

    private int heatReductionIndex;

    public HeatReactor(int id, Container container, int heatReductionIndex) {
        super(id, container);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing() + heatReductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        if(super.getContainer().getTotalEnergyOutput() > this.getTotalHeatAbsorbing()){
            return 0;
        }
        return super.getContainer().getTotalEnergyOutput();
    }
}
