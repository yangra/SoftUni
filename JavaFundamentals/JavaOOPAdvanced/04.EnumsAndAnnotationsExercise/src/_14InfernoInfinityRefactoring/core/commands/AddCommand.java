package _14InfernoInfinityRefactoring.core.commands;

import _14InfernoInfinityRefactoring.enums.Gem;
import _14InfernoInfinityRefactoring.models.contracts.Weapon;

public class AddCommand extends Command {
    @Override
    public String execute() {
        Weapon weapon = super.getWeaponRepository().get(super.getParams()[0]);
        if (weapon != null) {
            try {
                int index = Integer.parseInt(super.getParams()[1]);
                Gem gem = Gem.valueOf(super.getParams()[2]);
                weapon.addGem(gem, index);
                return null;
            } catch (NumberFormatException nfe){
                throw new IllegalArgumentException(String.format("Invalid index %s", super.getParams()[1]));
            } catch (IllegalArgumentException iae) {
                throw new IllegalArgumentException(String.format("Invalid gem name %s", super.getParams()[2]));
            }
        }else{
            throw new IllegalArgumentException(String.format("Invalid weapon name %s", super.getParams()[0]));
        }
    }
}