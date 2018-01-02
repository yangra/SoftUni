package app.waste_disposal.models.waste;

import app.waste_disposal.annotations.Burnable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

@Burnable
public class BurnableGarbage extends WasteImpl{

    public BurnableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }

}
