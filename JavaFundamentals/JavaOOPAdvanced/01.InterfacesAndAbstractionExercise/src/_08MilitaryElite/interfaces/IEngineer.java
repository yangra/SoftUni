package _08MilitaryElite.interfaces;

import _08MilitaryElite.soldiers.Repair;

import java.util.List;
import java.util.Set;

public interface IEngineer extends ISpecializedSoldier {
    List<IRepair> getRepairs();
}
