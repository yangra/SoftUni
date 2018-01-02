package app.models.bloodCells;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    public long getEnergy(){
        return this.velocity + super.getHealth();
    }

    @Override
    public String toString() {
        return super.toString()+ String.format("--------Health: %d | Velocity: %d | Energy: %d",
                super.getHealth(), this.velocity, this.getEnergy() );
    }
}
