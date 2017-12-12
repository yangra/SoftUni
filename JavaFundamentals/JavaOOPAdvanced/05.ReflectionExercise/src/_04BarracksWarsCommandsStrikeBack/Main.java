package _04BarracksWarsCommandsStrikeBack;

import _04BarracksWarsCommandsStrikeBack.contracts.Repository;
import _04BarracksWarsCommandsStrikeBack.contracts.Runnable;
import _04BarracksWarsCommandsStrikeBack.contracts.UnitFactory;
import _04BarracksWarsCommandsStrikeBack.core.Engine;
import _04BarracksWarsCommandsStrikeBack.core.factories.UnitFactoryImpl;
import _04BarracksWarsCommandsStrikeBack.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
