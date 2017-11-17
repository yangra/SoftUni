package _10MooD3;

public class Archangel extends BaseGameObject {
    private int mana;

    public Archangel(String username, int level, int mana) {
        super(username, level);
        this.mana = mana;
    }

    @Override
    protected String hashPassword() {
        return new StringBuilder(super.getUsername()).reverse().toString() + (super.getUsername().length() * 21);
    }

    @Override
    public String toString() {
        return super.toString() + this.mana * super.getLevel();
    }
}
