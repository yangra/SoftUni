package cresla.entities.containers;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Map;

public class ModuleContainerTest {

    private static final int EXPECTED_ENERGY_OUTPUT = 200;
    private static final int EXPECTED_TOTAL_HEAT_ABSORBTION = 300;
    private static final int EXPECTED_HEAT_ABSORBTION = 200;
    private static final int EXPECTED_TOTAL_ENERGY_OUTPUT = 300;


    @Before
    public  void init(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullEnergyModule() throws Exception {
        EnergyModule energyModule = null;
        Container container = new ModuleContainer(16);
        container.addEnergyModule(energyModule);
    }

    @Test
    public void addEnergyModuleToFullContainer() throws Exception {
        EnergyModule energyModule1 = Mockito.mock(EnergyModule.class);
        EnergyModule energyModule2 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModule1.getEnergyOutput()).thenReturn(100);
        Mockito.when(energyModule2.getEnergyOutput()).thenReturn(200);

        Container container = new ModuleContainer(1);
        container.addEnergyModule(energyModule1);
        container.addEnergyModule(energyModule2);

        Assert.assertEquals("Does not add properly when container full", EXPECTED_ENERGY_OUTPUT, container.getTotalEnergyOutput());
    }

    @Test
    public void addEnergyModuleToContainer() throws Exception {
        EnergyModule energyModule1 = Mockito.mock(EnergyModule.class);
        EnergyModule energyModule2 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModule1.getId()).thenReturn(1);
        Mockito.when(energyModule1.getEnergyOutput()).thenReturn(100);
        Mockito.when(energyModule2.getId()).thenReturn(2);
        Mockito.when(energyModule2.getEnergyOutput()).thenReturn(200);

        Container container = new ModuleContainer(16);
        container.addEnergyModule(energyModule1);
        container.addEnergyModule(energyModule2);

        Assert.assertEquals("Does not add module properly", EXPECTED_TOTAL_ENERGY_OUTPUT, container.getTotalEnergyOutput());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullAbsorbingModule() throws Exception {
        AbsorbingModule absorbingModule = null;
        Container container = new ModuleContainer(16);
        container.addAbsorbingModule(absorbingModule);
    }

    @Test
    public void addAbsorbingModuleToFullContainer() throws Exception {
        AbsorbingModule absorbingModule1 = Mockito.mock(AbsorbingModule.class);
        AbsorbingModule absorbingModule2 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModule1.getHeatAbsorbing()).thenReturn(100);
        Mockito.when(absorbingModule2.getHeatAbsorbing()).thenReturn(200);

        Container container = new ModuleContainer(1);
        container.addAbsorbingModule(absorbingModule1);
        container.addAbsorbingModule(absorbingModule2);

        Assert.assertEquals("Does not add absorbing module properly on full collection",
                EXPECTED_HEAT_ABSORBTION, container.getTotalHeatAbsorbing());

    }

    @Test
    public void addAbsorbingModule() throws Exception {
        AbsorbingModule absorbingModule1 = Mockito.mock(AbsorbingModule.class);
        AbsorbingModule absorbingModule2 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModule1.getHeatAbsorbing()).thenReturn(100);
        Mockito.when(absorbingModule1.getId()).thenReturn(1);
        Mockito.when(absorbingModule2.getHeatAbsorbing()).thenReturn(200);
        Mockito.when(absorbingModule2.getId()).thenReturn(2);

        Container container = new ModuleContainer(16);
        container.addAbsorbingModule(absorbingModule1);
        container.addAbsorbingModule(absorbingModule2);

        Assert.assertEquals("Does not add absorbing module properly",
                EXPECTED_TOTAL_HEAT_ABSORBTION, container.getTotalHeatAbsorbing());

    }

    @Test
    public void getTotalEnergyOutput() throws Exception {
        EnergyModule energyModule1 = Mockito.mock(EnergyModule.class);
        EnergyModule energyModule2 = Mockito.mock(EnergyModule.class);
        EnergyModule energyModule3 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModule1.getId()).thenReturn(1);
        Mockito.when(energyModule1.getEnergyOutput()).thenReturn(1000000000);
        Mockito.when(energyModule2.getId()).thenReturn(2);
        Mockito.when(energyModule2.getEnergyOutput()).thenReturn(1000000000);
        Mockito.when(energyModule3.getId()).thenReturn(3);
        Mockito.when(energyModule3.getEnergyOutput()).thenReturn(1000000000);

        Container container = new ModuleContainer(16);
        container.addEnergyModule(energyModule1);
        container.addEnergyModule(energyModule2);
        container.addEnergyModule(energyModule3);

        Assert.assertEquals("Does not add energy output properly", 3000000000L, container.getTotalEnergyOutput());
    }

    @Test
    public void getTotalHeatAbsorbing() throws Exception {
        AbsorbingModule absorbingModule1 = Mockito.mock(AbsorbingModule.class);
        AbsorbingModule absorbingModule2 = Mockito.mock(AbsorbingModule.class);
        AbsorbingModule absorbingModule3 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModule1.getHeatAbsorbing()).thenReturn(1000000000);
        Mockito.when(absorbingModule1.getId()).thenReturn(1);
        Mockito.when(absorbingModule2.getHeatAbsorbing()).thenReturn(1000000000);
        Mockito.when(absorbingModule2.getId()).thenReturn(2);
        Mockito.when(absorbingModule3.getHeatAbsorbing()).thenReturn(1000000000);
        Mockito.when(absorbingModule3.getId()).thenReturn(3);

        Container container = new ModuleContainer(16);
        container.addAbsorbingModule(absorbingModule1);
        container.addAbsorbingModule(absorbingModule2);
        container.addAbsorbingModule(absorbingModule3);

        Assert.assertEquals("Does not add absorbing heat properly",
                3000000000L, container.getTotalHeatAbsorbing());
    }



    @Test
    public void removeModulesAfterCapacityIsFull() throws Exception {
        AbsorbingModule absorbingModule1 = Mockito.mock(AbsorbingModule.class);
        AbsorbingModule absorbingModule2 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModule1.getHeatAbsorbing()).thenReturn(100);
        Mockito.when(absorbingModule1.getId()).thenReturn(1);
        Mockito.when(absorbingModule2.getHeatAbsorbing()).thenReturn(200);
        Mockito.when(absorbingModule2.getId()).thenReturn(2);


        EnergyModule energyModule1 = Mockito.mock(EnergyModule.class);
        EnergyModule energyModule2 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModule1.getEnergyOutput()).thenReturn(100);
        Mockito.when(energyModule1.getId()).thenReturn(1);
        Mockito.when(energyModule2.getEnergyOutput()).thenReturn(200);
        Mockito.when(energyModule2.getId()).thenReturn(2);


        Container container = new ModuleContainer(1);
        container.addAbsorbingModule(absorbingModule1);
        container.addAbsorbingModule(absorbingModule2);

        Field absorbingModules = container.getClass().getDeclaredField("absorbingModules");
        absorbingModules.setAccessible(true);
        Map<Integer,AbsorbingModule> absModules = (Map<Integer, AbsorbingModule>) absorbingModules.get(container);
        Assert.assertEquals("Does not remove from absorbing modules properly",
                1, absModules.size());


        container.addEnergyModule(energyModule1);
        container.addEnergyModule(energyModule2);

        Field energyModules = container.getClass().getDeclaredField("energyModules");
        energyModules.setAccessible(true);
        Map<Integer,EnergyModule> engModules = (Map<Integer, EnergyModule>) energyModules.get(container);
        Assert.assertEquals("Does not remove from energy modules properly",
                1, engModules.size());
    }

}