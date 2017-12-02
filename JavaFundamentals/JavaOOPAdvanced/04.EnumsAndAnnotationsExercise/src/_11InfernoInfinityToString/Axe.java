package _11InfernoInfinityToString;

import _11InfernoInfinityToString.enums.Gem;
import _11InfernoInfinityToString.enums.WeaponType;

public class Axe extends WeaponImpl {
    public Axe(String name) {
        super.setName(name);
        super.setMinDamage(WeaponType.AXE.getMinDamage());
        super.setMaxDamage(WeaponType.AXE.getMaxDamage());
        super.setSockets(new Gem[WeaponType.AXE.getSockets()]);
    }
}
