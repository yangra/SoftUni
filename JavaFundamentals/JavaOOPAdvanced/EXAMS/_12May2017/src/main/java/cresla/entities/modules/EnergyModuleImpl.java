package cresla.entities.modules;

import cresla.interfaces.EnergyModule;

public abstract class EnergyModuleImpl extends ModuleImpl implements EnergyModule {

    private int energyOutput;

    protected EnergyModuleImpl(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        return String.format("%s Module - %d\n%s: %d",
                this.getClass().getSimpleName(), super.getId(), "Energy Output", this.getEnergyOutput());
    }
}
