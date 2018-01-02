package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public abstract class ReactorImpl implements Reactor {

    private static String CONTAINER_CLASS_PATH = "cresla.entities.containers.";

    private int id;
    private Container container;

    protected ReactorImpl(int id, Container container) {
        this.id = id;
        this.container = container;
    }

//    @Override
//    public long getTotalEnergyOutput() {
//        return container.getTotalEnergyOutput();
//    }

    @Override
    public int getModuleCount() {
        try {
            Class<?> containerClass = Class.forName(CONTAINER_CLASS_PATH + "ModuleContainer");
            Field modulesByInput = containerClass.getDeclaredField("modulesByInput");
            modulesByInput.setAccessible(true);
            List<Module> modules = (List<Module>) modulesByInput.get(this.container);
            return modules.size();
        } catch ( IllegalAccessException | ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public abstract long getTotalHeatAbsorbing();

    @Override
    public abstract long getTotalEnergyOutput();

    @Override
    public int getId() {
        return this.id;
    }

    protected Container getContainer() {
        return this.container;
    }

    @Override
    public String toString() {
        return String.format("%s - %d\n" +
                        "Energy Output: %d\n" +
                        "Heat Absorbing: %d\n" +
                        "Modules: %d", this.getClass().getSimpleName(),
                this.id, this.getTotalEnergyOutput(),
                this.getTotalHeatAbsorbing(),
                this.getModuleCount());
    }
}
