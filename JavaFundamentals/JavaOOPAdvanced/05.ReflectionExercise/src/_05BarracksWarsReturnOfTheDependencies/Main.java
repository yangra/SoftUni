package _05BarracksWarsReturnOfTheDependencies;

import _05BarracksWarsReturnOfTheDependencies.contracts.CommandInterpreter;
import _05BarracksWarsReturnOfTheDependencies.contracts.Repository;
import _05BarracksWarsReturnOfTheDependencies.contracts.Runnable;
import _05BarracksWarsReturnOfTheDependencies.contracts.UnitFactory;
import _05BarracksWarsReturnOfTheDependencies.core.CommandInterpreterImpl;
import _05BarracksWarsReturnOfTheDependencies.core.Engine;
import _05BarracksWarsReturnOfTheDependencies.core.factories.UnitFactoryImpl;
import _05BarracksWarsReturnOfTheDependencies.data.UnitRepository;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl();
		Runnable engine = new Engine(repository, unitFactory, commandInterpreter);
		engine.run();



	}
}
