package cresla.factories;

import cresla.entities.containers.ModuleContainer;
import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

public final class ReactorFactory {
    private ReactorFactory() {
    }

    public static Reactor createCryoReactor(int id, int containerCapacity, int cryoProductionIndex){
        Container container = new ModuleContainer(containerCapacity);
        return new CryoReactor(id,container, cryoProductionIndex);
    }

    public static Reactor createHeatReactor(int id, int containerCapacity, int heatReductionIndex){
        Container container =  new ModuleContainer(containerCapacity);
        return new HeatReactor(id, container, heatReductionIndex);
    }
}
