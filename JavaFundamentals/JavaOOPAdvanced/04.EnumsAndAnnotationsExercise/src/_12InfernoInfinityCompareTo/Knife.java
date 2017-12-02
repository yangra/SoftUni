package _12InfernoInfinityCompareTo;

import _12InfernoInfinityCompareTo.enums.Gem;
import _12InfernoInfinityCompareTo.enums.WeaponType;

public class Knife extends WeaponImpl {
    public Knife(String name) {
        super.setName(name);
        super.setDefaultMinDamage(WeaponType.KNIFE.getMinDamage());
        super.setDefaultMaxDamage(WeaponType.KNIFE.getMaxDamage());
        super.setSockets(new Gem[WeaponType.KNIFE.getSockets()]);
    }
}
