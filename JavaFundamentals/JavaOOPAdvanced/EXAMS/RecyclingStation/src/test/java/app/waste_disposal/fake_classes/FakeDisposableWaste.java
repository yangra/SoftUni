package app.waste_disposal.fake_classes;

import app.waste_disposal.contracts.Waste;

@FakeDisposable
public class FakeDisposableWaste implements Waste {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getVolumePerKg() {
        return 0;
    }

    @Override
    public double getWeight() {
        return 0;
    }
}
