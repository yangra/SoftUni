package _10InfernoInfinity;

public class Axe extends WeaponImpl {
    public Axe(String name) {
        super();
        super.setName(name);
        super.setMinDamage(5);
        super.setMaxDamage(10);
        super.setSockets(new Gem[4]);
    }
}
