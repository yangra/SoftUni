package app.waste_disposal.factories;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.models.ProcessDataImpl;

public final class ProcessingDataFactory {

    private ProcessingDataFactory() {
    }

    public static ProcessingData createProcessingData(double energyBalance, double capitalBalance){
        return  new ProcessDataImpl(energyBalance,capitalBalance);
    }
}
