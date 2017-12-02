package _14InfernoInfinityRefactoring.factories;

import _14InfernoInfinityRefactoring.models.Axe;
import _14InfernoInfinityRefactoring.models.Knife;
import _14InfernoInfinityRefactoring.models.Sword;
import _14InfernoInfinityRefactoring.models.contracts.Weapon;

public final class WeaponFactory {
    private WeaponFactory() {
    }

    public static Weapon makeAxe(String name){
        return new Axe(name);
    }

    public static Weapon makeSword(String name){
        return new Sword(name);
    }

    public static Weapon makeKnife(String name){
        return new Knife(name);
    }
}
