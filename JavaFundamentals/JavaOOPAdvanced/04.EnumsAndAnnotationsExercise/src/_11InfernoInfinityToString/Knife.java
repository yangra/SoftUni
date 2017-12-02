package _11InfernoInfinityToString;

import _11InfernoInfinityToString.enums.Gem;
import _11InfernoInfinityToString.enums.WeaponType;

public class Knife extends WeaponImpl {
    public Knife(String name) {
        super.setName(name);
        super.setMinDamage(WeaponType.KNIFE.getMinDamage());
        super.setMaxDamage(WeaponType.KNIFE.getMaxDamage());
        super.setSockets(new Gem[WeaponType.KNIFE.getSockets()]);
    }
}
