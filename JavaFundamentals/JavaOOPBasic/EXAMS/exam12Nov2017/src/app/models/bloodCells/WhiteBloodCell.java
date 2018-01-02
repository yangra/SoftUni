package app.models.bloodCells;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }


    public long getEnergy(){
       return (this.size + super.getHealth()) * 2;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("--------Health: %d | Size: %d | Energy: %d",
                super.getHealth(), this.size, this.getEnergy() );
    }
}
