package _10July2016.factories;

import _10July2016.models.hardware.HardwareComponent;
import _10July2016.models.hardware.HeavyHardwareComponent;
import _10July2016.models.hardware.PowerHardwareComponent;

public final class HardwareFactory {
    private HardwareFactory() {
    }

    public static HardwareComponent makePowerHardware(String name, int capacity, int memory){
        return new PowerHardwareComponent(name, capacity,memory);
    }

    public static HardwareComponent makeHeavyHardware(String name, int capacity, int memory){
        return new HeavyHardwareComponent(name, capacity,memory);
    }
}
