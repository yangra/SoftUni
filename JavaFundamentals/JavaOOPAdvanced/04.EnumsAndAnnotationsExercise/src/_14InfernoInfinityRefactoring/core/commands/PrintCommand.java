package _14InfernoInfinityRefactoring.core.commands;

import _14InfernoInfinityRefactoring.models.contracts.Weapon;

public class PrintCommand extends Command {
    @Override
    public String execute() {
        Weapon weapon = super.getWeaponRepository().get(super.getParams()[0]);
        if (weapon != null) {
            return weapon.toString();
        }else{
            throw new IllegalArgumentException(String.format("Invalid weapon name %s",super.getParams()[0]));
        }

    }
}
