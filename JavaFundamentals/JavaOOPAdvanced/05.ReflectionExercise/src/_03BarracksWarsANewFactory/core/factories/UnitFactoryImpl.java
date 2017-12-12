package _03BarracksWarsANewFactory.core.factories;



import _03BarracksWarsANewFactory.contracts.Unit;
import _03BarracksWarsANewFactory.contracts.UnitFactory;
import _03BarracksWarsANewFactory.models.units.Swordsman;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"_03BarracksWarsANewFactory.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InstantiationException,
            InvocationTargetException {

        return (Unit) Class.forName(UNITS_PACKAGE_NAME + unitType).getDeclaredConstructor().newInstance();
	}
}
