package _10July2016.factories;

import _10July2016.models.software.ExpressSoftwareComponent;
import _10July2016.models.software.LightSoftwareComponent;
import _10July2016.models.software.SoftwareComponent;

public final class SoftwareFactory {
    private SoftwareFactory() {
    }

    public static SoftwareComponent makeExpressSoftware(String name, int capacity, int memory){
        return new ExpressSoftwareComponent(name,   capacity,memory);
    }

    public static SoftwareComponent makeLightSoftware(String name, int capacity, int memory){
        return new LightSoftwareComponent(name, capacity,memory);
    }
}
