package _08MilitaryElite.soldiers;

import _08MilitaryElite.interfaces.ISpy;

public class Spy extends Soldier implements ISpy {
    private String codeNumber;

    public Spy(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + String.format("Code Number: %s", this.codeNumber);
    }
}
