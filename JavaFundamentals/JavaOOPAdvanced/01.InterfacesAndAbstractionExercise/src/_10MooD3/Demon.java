package _10MooD3;

public class Demon extends BaseGameObject {
    private double energy;

    public Demon(String username, int level, double energy) {
        super(username, level);
        this.energy = energy;
    }

    @Override
    protected String hashPassword() {
        return String.valueOf(super.getUsername().length() * 217);
    }

    @Override
    public String toString() {
        return super.toString() + this.energy * super.getLevel();
    }
}
