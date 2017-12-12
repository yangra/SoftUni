package _04BarracksWarsCommandsStrikeBack.contracts;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType);

}
