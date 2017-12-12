package _03BarracksWarsANewFactory;


import _03BarracksWarsANewFactory.contracts.Repository;
import _03BarracksWarsANewFactory.contracts.UnitFactory;
import _03BarracksWarsANewFactory.core.Engine;
import _03BarracksWarsANewFactory.core.factories.UnitFactoryImpl;
import _03BarracksWarsANewFactory.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
