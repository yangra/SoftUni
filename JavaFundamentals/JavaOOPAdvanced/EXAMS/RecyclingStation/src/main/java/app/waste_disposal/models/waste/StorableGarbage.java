package app.waste_disposal.models.waste;

import app.waste_disposal.annotations.Storable;

@Storable
public class StorableGarbage extends WasteImpl {

    public StorableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
