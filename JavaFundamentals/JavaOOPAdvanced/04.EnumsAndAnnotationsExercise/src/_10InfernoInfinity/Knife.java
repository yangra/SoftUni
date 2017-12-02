package _10InfernoInfinity;

public class Knife extends WeaponImpl {
    public Knife(String name) {
        super();
        super.setName(name);
        super.setMinDamage(3);
        super.setMaxDamage(4);
        super.setSockets(new Gem[2]);
    }
}
