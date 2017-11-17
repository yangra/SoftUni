package _08MilitaryElite.interfaces;

import _08MilitaryElite.soldiers.Mission;

import java.util.List;
import java.util.Set;

public interface ICommando extends ISpecializedSoldier{
    List<IMission> getMissions();
}
