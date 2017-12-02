package _14InfernoInfinityRefactoring.repositories;

import _14InfernoInfinityRefactoring.models.contracts.Weapon;

import java.util.HashMap;
import java.util.Map;

public class WeaponRepository implements Repository<Weapon> {

    private Map<String, Weapon> weapons;

    public WeaponRepository() {
        this.weapons = new HashMap<>();
    }

    @Override
    public void add(Weapon weapon) {
        this.weapons.putIfAbsent(weapon.getName(), weapon);
    }

    @Override
    public Weapon get(String weaponName) {
        return this.weapons.get(weaponName);
    }
}
