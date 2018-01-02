package cresla.entities.reactors;


import cresla.interfaces.Container;

public class CryoReactor extends ReactorImpl {

    private int cryoProductionIndex;

    public CryoReactor(int id, Container container, int cryoProductionIndex) {
        super(id, container);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        if(this.getTotalHeatAbsorbing() < super.getContainer().getTotalEnergyOutput() * this.cryoProductionIndex){
            return 0;
        }

        return super.getContainer().getTotalEnergyOutput() * this.cryoProductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing();
    }

}
