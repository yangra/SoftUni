public class InvaderImpl implements Invader {
    private int damage;
    private int distance;

    public InvaderImpl(int damage, int distance) {
        this.damage = damage;
        this.distance = distance;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getDistance() {
        return  this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int compareTo(Invader other) {
        if(this.distance != other.getDistance()){
            return Integer.compare(this.distance, other.getDistance());
        }

        return Integer.compare( other.getDamage(),this.damage);
    }

    @Override
    public String toString() {
        return String.format("%d-%d", this.distance, this.damage);
    }
}
