package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.factories.ProcessingDataFactory;


public class Storing implements GarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyBalance = 0 - garbage.getWeight() * garbage.getVolumePerKg() * 13.0 / 100;
        double capitalBalance = 0 - garbage.getWeight() * garbage.getVolumePerKg() * 65.0 / 100;
        return ProcessingDataFactory.createProcessingData(energyBalance, capitalBalance);
    }
}
