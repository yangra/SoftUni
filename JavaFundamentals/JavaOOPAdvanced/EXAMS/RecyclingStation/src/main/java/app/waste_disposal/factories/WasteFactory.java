package app.waste_disposal.factories;

import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.waste.BurnableGarbage;
import app.waste_disposal.models.waste.RecyclableGarbage;
import app.waste_disposal.models.waste.StorableGarbage;

public final class WasteFactory {
    private WasteFactory() {
    }

    public static Waste createBurnableGarbge(String name, double weight, double volumePerKg){
        return  new BurnableGarbage(name, weight, volumePerKg);
    }

    public static Waste createStorableGarbge(String name, double weight, double volumePerKg){
        return  new StorableGarbage(name, weight, volumePerKg);
    }

    public static Waste createRecyclableGarbage(String name, double weight, double volumePerKg){
        return  new RecyclableGarbage(name, weight, volumePerKg);
    }


}

