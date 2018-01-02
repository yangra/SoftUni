package cresla.factories;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;

public final class ModuleFactory {
    private ModuleFactory() {
    }

    public static EnergyModule createCryogenRod(int id, int energyOutput){
        return new CryogenRod(id, energyOutput);
    }

    public static AbsorbingModule createCooldownSystem(int id, int heatAbsorbing){
        return new CooldownSystem(id, heatAbsorbing);
    }

    public static AbsorbingModule createHeatProcessor(int id, int heatAbsorbing){
        return new HeatProcessor(id, heatAbsorbing);
    }
}
