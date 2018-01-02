package cresla.controllers;

import cresla.factories.ModuleFactory;
import cresla.factories.ReactorFactory;
import cresla.interfaces.*;


import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReactorManager implements Manager {

    private static String MODULE_CONTAINER_PATH = "cresla.entities.containers.";


    private int lastGivenId;
    private int uploadedEnergyModules;
    private int uploadedAbsorbingModules;
    private Map<Integer, Reactor> reactors;

    public ReactorManager() {
        this.lastGivenId = 0;
        this.reactors = new LinkedHashMap<>();
        this.uploadedAbsorbingModules = 0;
        this.uploadedEnergyModules = 0;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Reactor reactor = null;
        switch (arguments.get(0)) {
            case "Cryo":
                reactor = ReactorFactory.createCryoReactor(++this.lastGivenId,
                        Integer.parseInt(arguments.get(2)),
                        Integer.parseInt(arguments.get(1)));
                this.reactors.put(this.lastGivenId, reactor);
                break;
            case "Heat":
                reactor = ReactorFactory.createHeatReactor(++this.lastGivenId,
                        Integer.parseInt(arguments.get(2)),
                        Integer.parseInt(arguments.get(1)));
                this.reactors.put(this.lastGivenId, reactor);
                break;
            default:
                throw new IllegalArgumentException("Invalid reactor type");
        }

        return String.format("Created %s Reactor - %d", arguments.get(0), reactor.getId());
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        if (!reactors.containsKey(Integer.parseInt(arguments.get(0)))) {
            throw new IllegalArgumentException("Reactor with this id doesn't exist");
        }

        Reactor reactor = null;
        AbsorbingModule absorbingModule = null;
        EnergyModule energyModule = null;
        switch (arguments.get(1)) {
            case "CryogenRod":
                energyModule = ModuleFactory.createCryogenRod(++this.lastGivenId, Integer.parseInt(arguments.get(2)));
                reactor = reactors.get(Integer.parseInt(arguments.get(0)));
                reactor.addEnergyModule(energyModule);
                this.uploadedEnergyModules++;
                break;
            case "CooldownSystem":
                absorbingModule = ModuleFactory.createCooldownSystem(++this.lastGivenId, Integer.parseInt(arguments.get(2)));
                reactor = reactors.get(Integer.parseInt(arguments.get(0)));
                reactor.addAbsorbingModule(absorbingModule);
                this.uploadedAbsorbingModules++;
                break;
            case "HeatProcessor":
                absorbingModule = ModuleFactory.createHeatProcessor(++this.lastGivenId, Integer.parseInt(arguments.get(2)));
                reactor = reactors.get(Integer.parseInt(arguments.get(0)));
                reactor.addAbsorbingModule(absorbingModule);
                this.uploadedAbsorbingModules++;
                break;
            default:
                throw new IllegalArgumentException("Invalid module type");
        }

        return String.format("Added %s - %d to Reactor - %d", arguments.get(1), this.lastGivenId, reactor.getId());
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int id = Integer.parseInt(arguments.get(0));
        if (this.reactors.containsKey(id)) {
            Reactor reactor = this.reactors.get(id);
            return reactor.toString();
        }

        Module module = null;
        for (Reactor reactor : this.reactors.values()) {

            try {
                Class<?> reactorClass = reactor.getClass();
                Field containerField = reactorClass.getSuperclass().getDeclaredField("container");
                containerField.setAccessible(true);
                Container container = (Container) containerField.get(reactor);
                Class<?> containerClass = Class.forName(MODULE_CONTAINER_PATH + "ModuleContainer");
                Field modulesField = containerClass.getDeclaredField("modulesByInput");
                modulesField.setAccessible(true);
                List<Module> modules = (List<Module>) modulesField.get(container);
                for (Module mod : modules) {
                    if(mod.getId() == id){
                        module = mod;
                    }
                }

            } catch ( IllegalAccessException | ClassNotFoundException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        return module.toString();
    }

    @Override
    public String exitCommand(List<String> arguments) {

        int cryoReactorsCount = 0;
        int heatReactorsCount = 0;
        for (Reactor reactor : reactors.values()) {
            if(reactor.getClass().getSimpleName().equals("CryoReactor")){
                cryoReactorsCount++;
            }else {
                heatReactorsCount++;
            }
        }

        return String.format("Cryo Reactors: %d\n" +
                "Heat Reactors: %d\n" +
                "Energy Modules: %d\n" +
                "Absorbing Modules: %d\n" +
                "Total Energy Output: %d\n" +
                "Total Heat Absorbing: %d",
                cryoReactorsCount, heatReactorsCount, this.uploadedEnergyModules,
                this.uploadedAbsorbingModules,
                this.reactors.values().stream().mapToLong(r->r.getTotalEnergyOutput()).sum(),
                this.reactors.values().stream().mapToLong(r->r.getTotalHeatAbsorbing()).sum());
    }

}
