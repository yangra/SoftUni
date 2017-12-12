package _05BarracksWarsReturnOfTheDependencies.contracts;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType);

}
