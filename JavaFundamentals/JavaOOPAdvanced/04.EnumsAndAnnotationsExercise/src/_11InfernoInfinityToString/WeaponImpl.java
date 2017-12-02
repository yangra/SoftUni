package _11InfernoInfinityToString;

import _11InfernoInfinityToString.enums.Gem;

public abstract class WeaponImpl implements Weapon {
    private String name;
    private int minDamage;
    private int maxDamage;
    private Gem[] sockets;

    protected WeaponImpl() {
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
    public String toString() {
        int strength = 0;
        int agility = 0;
        int vitality = 0;
        int addMinDamage = this.minDamage;
        int addMaxDamage = this.maxDamage;
        for (Gem gem : this.sockets) {
            if (gem != null) {
                strength += gem.getStrength();
                agility += gem.getAgility();
                vitality += gem.getVitality();
            }
        }
        addMinDamage += strength * 2 + agility;
        addMaxDamage += strength * 3 + agility * 4;

        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name, addMinDamage, addMaxDamage, strength, agility, vitality);
    }
}
