package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.factories.ProcessingDataFactory;


public class Burning implements GarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyBalance = garbage.getVolumePerKg() * garbage.getWeight() - garbage.getWeight() * garbage.getVolumePerKg() / 5;
        double capitalBalance = 0;
        return ProcessingDataFactory.createProcessingData(energyBalance, capitalBalance);
    }
}
