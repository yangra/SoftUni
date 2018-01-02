package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.factories.ProcessingDataFactory;


public class Recycling implements GarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyBalance = 0 - garbage.getWeight() * garbage.getVolumePerKg() / 2;
        double capitalBalance = 400 * garbage.getWeight();
        return ProcessingDataFactory.createProcessingData(energyBalance, capitalBalance);
    }
}
