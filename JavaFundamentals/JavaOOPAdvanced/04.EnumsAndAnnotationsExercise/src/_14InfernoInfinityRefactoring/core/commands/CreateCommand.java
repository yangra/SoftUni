package _14InfernoInfinityRefactoring.core.commands;

import _14InfernoInfinityRefactoring.models.contracts.Weapon;
import _14InfernoInfinityRefactoring.factories.WeaponFactory;

public class CreateCommand extends Command {
    @Override
    public String execute() {
        Weapon weapon = null;

        switch (super.getParams()[0].toLowerCase()) {
            case "axe":
                weapon = WeaponFactory.makeAxe(super.getParams()[1]);
                break;
            case "sword":
                weapon = WeaponFactory.makeSword(super.getParams()[1]);
                break;
            case "knife":
                weapon = WeaponFactory.makeKnife(super.getParams()[1]);
                break;
        }

        if(weapon!=null) {
            super.getWeaponRepository().add(weapon);
        }else {
            throw new IllegalArgumentException("Invalid command!");
        }
        return null;
    }
}
