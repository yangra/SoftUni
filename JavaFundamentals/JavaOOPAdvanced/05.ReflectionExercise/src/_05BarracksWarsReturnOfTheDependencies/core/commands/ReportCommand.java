package _05BarracksWarsReturnOfTheDependencies.core.commands;

import _05BarracksWarsReturnOfTheDependencies.contracts.Repository;
import _05BarracksWarsReturnOfTheDependencies.contracts.UnitFactory;

public class ReportCommand extends Command {

    @Override
    public String execute() {
            return super.getUnitRepository().getStatistics();
    }
}
