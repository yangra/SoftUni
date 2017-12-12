package _04BarracksWarsCommandsStrikeBack.core.commands;

import _04BarracksWarsCommandsStrikeBack.contracts.Repository;
import _04BarracksWarsCommandsStrikeBack.contracts.Unit;
import _04BarracksWarsCommandsStrikeBack.contracts.UnitFactory;

public class AddCommand extends Command {
    public AddCommand(Repository unitRepository, UnitFactory unitFactory, String[] data) {
        super(unitRepository, unitFactory, data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getUnitRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
