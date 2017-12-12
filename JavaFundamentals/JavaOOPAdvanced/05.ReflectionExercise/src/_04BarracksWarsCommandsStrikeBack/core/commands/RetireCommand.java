package _04BarracksWarsCommandsStrikeBack.core.commands;

import _04BarracksWarsCommandsStrikeBack.contracts.Repository;
import _04BarracksWarsCommandsStrikeBack.contracts.Unit;
import _04BarracksWarsCommandsStrikeBack.contracts.UnitFactory;

public class RetireCommand extends Command {
    public RetireCommand(Repository unitRepository, UnitFactory unitFactory, String[] data) {
        super(unitRepository, unitFactory, data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        super.getUnitRepository().removeUnit(unitType);
        String output = unitType + " retired!";
        return output;
    }
}
