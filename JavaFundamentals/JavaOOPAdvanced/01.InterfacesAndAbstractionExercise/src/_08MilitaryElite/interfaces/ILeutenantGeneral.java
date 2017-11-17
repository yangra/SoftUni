package _08MilitaryElite.interfaces;

import _08MilitaryElite.soldiers.Private;

import java.util.List;

public interface ILeutenantGeneral extends IPrivate {
    List<IPrivate> getPrivates();
}
