package _14InfernoInfinityRefactoring.core.commands;

import _14InfernoInfinityRefactoring.models.contracts.Weapon;

public class CompareCommand extends Command {
    @Override
    public String execute() {
        Weapon weapon1 = super.getWeaponRepository().get(super.getParams()[0]);
        Weapon weapon2 = super.getWeaponRepository().get(super.getParams()[1]);

        if (weapon1 != null && weapon2 != null) {
            Weapon weapon = weapon1.compare(weapon2);
            return weapon.print();
        } else {
            throw new IllegalArgumentException(String.format("Invalid weapon name %s",
                    weapon1 == null ? super.getParams()[0] : super.getParams()[1]));
        }
    }
}
