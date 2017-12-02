package _13CreateCustomClassAnnotation;

import _13CreateCustomClassAnnotation.enums.Gem;
import _13CreateCustomClassAnnotation.enums.WeaponType;

public class Axe extends WeaponImpl {
    public Axe(String name) {
        super.setName(name);
        super.setDefaultMinDamage(WeaponType.AXE.getMinDamage());
        super.setDefaultMaxDamage(WeaponType.AXE.getMaxDamage());
        super.setSockets(new Gem[WeaponType.AXE.getSockets()]);
    }
}
