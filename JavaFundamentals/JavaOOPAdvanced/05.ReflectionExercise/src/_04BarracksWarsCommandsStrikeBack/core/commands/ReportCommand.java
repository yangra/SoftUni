package _04BarracksWarsCommandsStrikeBack.core.commands;

import _04BarracksWarsCommandsStrikeBack.contracts.Repository;
import _04BarracksWarsCommandsStrikeBack.contracts.UnitFactory;

public class ReportCommand extends Command{
    public ReportCommand(Repository unitRepository, UnitFactory unitFactory, String[] data) {
        super(unitRepository, unitFactory, data);
    }

    @Override
    public String execute() {
            return super.getUnitRepository().getStatistics();
    }
}
