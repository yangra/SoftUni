package _10InfernoInfinity;

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
