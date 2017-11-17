package _08MilitaryElite.soldiers;

import _08MilitaryElite.interfaces.ISpecializedSoldier;

public abstract class SpecializedSoldier extends Private implements ISpecializedSoldier {
    private static final String AIRFORCES = "Airforces";
    private static final String MARINES = "Marines";
    private String corps;

    public SpecializedSoldier(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    public void setCorps(String corps) {
        if (AIRFORCES.equals(corps) || MARINES.equals(corps)) {
            this.corps = corps;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
