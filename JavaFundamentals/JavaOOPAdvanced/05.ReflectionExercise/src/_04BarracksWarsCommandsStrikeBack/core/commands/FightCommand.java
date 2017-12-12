package _04BarracksWarsCommandsStrikeBack.core.commands;

import _04BarracksWarsCommandsStrikeBack.contracts.Repository;
import _04BarracksWarsCommandsStrikeBack.contracts.UnitFactory;

public class FightCommand extends Command {
    public FightCommand(Repository unitRepository, UnitFactory unitFactory, String[] data) {
        super(unitRepository, unitFactory, data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
