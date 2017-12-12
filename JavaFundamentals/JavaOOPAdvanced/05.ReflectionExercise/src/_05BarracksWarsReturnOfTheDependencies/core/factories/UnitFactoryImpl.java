package _05BarracksWarsReturnOfTheDependencies.core.factories;

import _05BarracksWarsReturnOfTheDependencies.contracts.Unit;
import _05BarracksWarsReturnOfTheDependencies.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"_05BarracksWarsReturnOfTheDependencies.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		try {
			return (Unit) Class.forName(UNITS_PACKAGE_NAME + unitType).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
