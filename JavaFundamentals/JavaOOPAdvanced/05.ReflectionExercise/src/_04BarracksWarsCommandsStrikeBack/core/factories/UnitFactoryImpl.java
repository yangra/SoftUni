package _04BarracksWarsCommandsStrikeBack.core.factories;

import _04BarracksWarsCommandsStrikeBack.contracts.Unit;
import _04BarracksWarsCommandsStrikeBack.contracts.UnitFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"_04BarracksWarsCommandsStrikeBack.models.units.";

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
