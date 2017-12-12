package _05BarracksWarsReturnOfTheDependencies.core.commands;

import _05BarracksWarsReturnOfTheDependencies.contracts.Repository;
import _05BarracksWarsReturnOfTheDependencies.contracts.UnitFactory;

public class RetireCommand extends Command {

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        super.getUnitRepository().removeUnit(unitType);
        String output = unitType + " retired!";
        return output;
    }
}
