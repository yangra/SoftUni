package _04BarracksWarsCommandsStrikeBack.core.commands;


import _04BarracksWarsCommandsStrikeBack.contracts.Executable;
import _04BarracksWarsCommandsStrikeBack.contracts.Repository;
import _04BarracksWarsCommandsStrikeBack.contracts.UnitFactory;

public abstract class Command implements Executable {

    private Repository unitRepository;
    private UnitFactory unitFactory;
    private String[] data;

    protected Command(Repository unitRepository, UnitFactory unitFactory, String[] data) {
        this.unitRepository = unitRepository;
        this.unitFactory = unitFactory;
        this.data = data;
    }

    protected Repository getUnitRepository() {
        return this.unitRepository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }

    protected String[] getData() {
        return this.data;
    }
}
