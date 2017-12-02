package _14InfernoInfinityRefactoring.models;

import _14InfernoInfinityRefactoring.enums.Gem;
import _14InfernoInfinityRefactoring.enums.WeaponType;

public class Sword extends WeaponImpl {
    public Sword(String name) {
        super.setName(name);
        super.setDefaultMinDamage(WeaponType.SWORD.getMinDamage());
        super.setDefaultMaxDamage(WeaponType.SWORD.getMaxDamage());
        super.setSockets(new Gem[WeaponType.SWORD.getSockets()]);
    }
}
