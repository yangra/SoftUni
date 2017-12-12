package _05BarracksWarsReturnOfTheDependencies.core.commands;


import _05BarracksWarsReturnOfTheDependencies.annotations.Inject;
import _05BarracksWarsReturnOfTheDependencies.contracts.Executable;
import _05BarracksWarsReturnOfTheDependencies.contracts.Repository;
import _05BarracksWarsReturnOfTheDependencies.contracts.UnitFactory;

public abstract class Command implements Executable {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;
    @Inject
    private String[] data;

    public Command() {
    }

    protected Repository getUnitRepository() {
        return this.repository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }

    protected String[] getData() {
        return this.data;
    }
}
