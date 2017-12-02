package _12InfernoInfinityCompareTo;

import _12InfernoInfinityCompareTo.enums.Gem;
import _12InfernoInfinityCompareTo.enums.WeaponType;

public class Sword extends WeaponImpl {
    public Sword(String name) {
        super.setName(name);
        super.setDefaultMinDamage(WeaponType.SWORD.getMinDamage());
        super.setDefaultMaxDamage(WeaponType.SWORD.getMaxDamage());
        super.setSockets(new Gem[WeaponType.SWORD.getSockets()]);
    }
}
