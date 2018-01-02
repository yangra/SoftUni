package app.waste_disposal.models.waste;

import app.waste_disposal.annotations.Recyclable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;

@Recyclable
public class RecyclableGarbage extends  WasteImpl {

    public RecyclableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }


}
