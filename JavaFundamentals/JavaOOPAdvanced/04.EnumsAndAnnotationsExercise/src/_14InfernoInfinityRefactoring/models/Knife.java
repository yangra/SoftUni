package _14InfernoInfinityRefactoring.models;

import _14InfernoInfinityRefactoring.enums.Gem;
import _14InfernoInfinityRefactoring.enums.WeaponType;

public class Knife extends WeaponImpl {
    public Knife(String name) {
        super.setName(name);
        super.setDefaultMinDamage(WeaponType.KNIFE.getMinDamage());
        super.setDefaultMaxDamage(WeaponType.KNIFE.getMaxDamage());
        super.setSockets(new Gem[WeaponType.KNIFE.getSockets()]);
    }
}
