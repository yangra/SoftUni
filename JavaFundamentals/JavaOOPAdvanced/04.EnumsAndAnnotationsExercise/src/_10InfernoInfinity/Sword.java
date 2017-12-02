package _10InfernoInfinity;

public class Sword extends WeaponImpl {
    public Sword(String name) {
        super();
        super.setName(name);
        super.setMinDamage(4);
        super.setMaxDamage(6);
        super.setSockets(new Gem[3]);
    }
}
