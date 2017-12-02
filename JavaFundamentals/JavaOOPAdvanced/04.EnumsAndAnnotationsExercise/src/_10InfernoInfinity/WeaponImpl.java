package _10InfernoInfinity;

public abstract class WeaponImpl implements Weapon {
    private String name;
    private int minDamage;
    private int maxDamage;
    private Gem[] sockets;
    private int strength;
    private int agility;
    private int vitality;

    public WeaponImpl() {
        this.strength = 0;
        this.agility = 0;
        this.vitality = 0;
    }

    protected String getName() {
        return this.name;
    }

    protected int getMinDamage() {
        return this.minDamage;
    }

    protected int getMaxDamage() {
        return this.maxDamage;
    }

    protected Gem[] getSockets() {
        return this.sockets;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    protected void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    protected void setSockets(Gem[] sockets) {
        this.sockets = sockets;
    }

    @Override
    public void addGem(Gem gem, int index) {
        if (index < 0 || index > this.sockets.length - 1) {
            return;
        }
        if (this.sockets[index] != null) {
            this.removeGem(index);
        }
        this.sockets[index] = gem;
        this.strength += gem.getStrength();
        this.agility += gem.getAgility();
        this.vitality += gem.getVitality();
        this.minDamage += gem.getStrength() * 2;
        this.maxDamage += gem.getStrength() * 3;
        this.minDamage += gem.getAgility();
        this.maxDamage += gem.getAgility() * 4;
    }

    @Override
    public void removeGem(int index) {
        if (index < 0 || index > this.sockets.length - 1) {
            return;
        }

        if (this.sockets[index] != null) {
            Gem gem = this.sockets[index];
            this.sockets[index] = null;
            this.strength -= gem.getStrength();
            this.agility -= gem.getAgility();
            this.vitality -= gem.getVitality();
            this.minDamage -= gem.getStrength() * 2;
            this.maxDamage -= gem.getStrength() * 3;
            this.minDamage -= gem.getAgility();
            this.maxDamage -= gem.getAgility() * 4;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name, this.minDamage, this.maxDamage, this.strength, this.agility, this.vitality);
    }
}
