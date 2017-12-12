package _05BarracksWarsReturnOfTheDependencies.core.commands;

import _05BarracksWarsReturnOfTheDependencies.contracts.Repository;
import _05BarracksWarsReturnOfTheDependencies.contracts.Unit;
import _05BarracksWarsReturnOfTheDependencies.contracts.UnitFactory;

public class AddCommand extends Command {


    @Override
    public String execute() {
        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getUnitRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
