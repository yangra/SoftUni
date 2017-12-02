package _11InfernoInfinityToString;

import _11InfernoInfinityToString.enums.Gem;
import _11InfernoInfinityToString.enums.WeaponType;

public class Sword extends WeaponImpl {
    public Sword(String name) {
        super.setName(name);
        super.setMinDamage(WeaponType.SWORD.getMinDamage());
        super.setMaxDamage(WeaponType.SWORD.getMaxDamage());
        super.setSockets(new Gem[WeaponType.SWORD.getSockets()]);
    }
}
