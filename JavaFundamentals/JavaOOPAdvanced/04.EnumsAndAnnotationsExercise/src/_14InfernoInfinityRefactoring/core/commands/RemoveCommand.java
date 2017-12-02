package _14InfernoInfinityRefactoring.core.commands;

import _14InfernoInfinityRefactoring.models.contracts.Weapon;

import java.util.IllegalFormatException;

public class RemoveCommand extends Command {
    @Override
    public String execute() {
        Weapon weapon = super.getWeaponRepository().get(super.getParams()[0]);
        if (weapon != null) {
            try {
                weapon.removeGem(Integer.parseInt(super.getParams()[1]));
            }catch (NumberFormatException nfe){
                throw new IllegalArgumentException(String.format("Invalid index %s", super.getParams()[1]));
            }

            return null;
        } else {
            throw new IllegalArgumentException(String.format("Invalid weapon name %s", super.getParams()[0]));
        }
    }
}
