package _13CreateCustomClassAnnotation;

import _13CreateCustomClassAnnotation.annotations.CustomAnnotation;
import _13CreateCustomClassAnnotation.enums.Gem;

@CustomAnnotation()
public abstract class WeaponImpl implements Weapon, Comparable<WeaponImpl> {
    private String name;
    private int defaultMinDamage;
    private int defaultMaxDamage;
    private Gem[] sockets;

    protected WeaponImpl() {
    }

    protected String getName() {
        return this.name;
    }

    protected int getMinDamage() {
        return this.defaultMinDamage + this.getStrength() * 2 + this.getAgility();
    }

    protected int getMaxDamage() {
        return this.defaultMaxDamage + this.getStrength() * 3 + this.getAgility() * 4;
    }

    protected Gem[] getSockets() {
        return this.sockets;
    }

    private int getAgility() {
        int agility = 0;
        for (Gem gem : sockets) {
            if (gem != null) {
                agility += gem.getAgility();
            }
        }
        return agility;
    }

    private int getStrength() {
        int strength = 0;
        for (Gem gem : sockets) {
            if (gem != null) {
                strength += gem.getStrength();
            }
        }
        return strength;
    }

    private int getVitality() {
        int vitality = 0;
        for (Gem gem : sockets) {
            if (gem != null) {
                vitality += gem.getVitality();
            }
        }
        return vitality;
    }

    private double getItemLevel() {
        return ((this.getMinDamage() + this.getMaxDamage()) / 2.0) +
                this.getStrength() + this.getAgility() + this.getVitality();

    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setDefaultMinDamage(int minDamage) {
        this.defaultMinDamage = minDamage;
    }

    protected void setDefaultMaxDamage(int maxDamage) {
        this.defaultMaxDamage = maxDamage;
    }

    protected void setSockets(Gem[] sockets) {
        this.sockets = sockets;
    }

    @Override
    public void addGem(Gem gem, int index) {
        if (index < 0 || index > this.sockets.length - 1) {
            return;
        }

        this.sockets[index] = gem;
    }

    @Override
    public void removeGem(int index) {
        if (index < 0 || index > this.sockets.length - 1) {
            return;
        }

        if (this.sockets[index] != null) {
            this.sockets[index] = null;
        }
    }

    @Override
    public int compareTo(WeaponImpl other) {
        return Double.compare(this.getItemLevel(), other.getItemLevel());
    }

    @Override
    public Weapon compare(Weapon other) {
        if (this.compareTo((WeaponImpl) other) >= 0) {
            return this;
        } else {
            return other;
        }
    }

    @Override
    public String print() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality (Item Level: %.1f)",
                this.getName(), this.getMinDamage(), this.getMaxDamage(),
                this.getStrength(), this.getAgility(), this.getVitality(), this.getItemLevel());

    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(), this.getMinDamage(), this.getMaxDamage(),
                this.getStrength(), this.getAgility(), this.getVitality());
    }
}
