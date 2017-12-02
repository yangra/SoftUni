package _14InfernoInfinityRefactoring.models;

import _14InfernoInfinityRefactoring.enums.Gem;
import _14InfernoInfinityRefactoring.enums.WeaponType;

public class Axe extends WeaponImpl {
    public Axe(String name) {
        super.setName(name);
        super.setDefaultMinDamage(WeaponType.AXE.getMinDamage());
        super.setDefaultMaxDamage(WeaponType.AXE.getMaxDamage());
        super.setSockets(new Gem[WeaponType.AXE.getSockets()]);
    }
}
