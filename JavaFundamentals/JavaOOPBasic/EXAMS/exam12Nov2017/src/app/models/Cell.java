package app.models;

public abstract class Cell {
    private String id;
    private long health;
    private int positionRow;
    private int positionCol;

    protected Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    public long getHealth() {
        return this.health;
    }

    public String getId() {
        return this.id;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public abstract Cell attack(Cell nextCell);

    public abstract long getEnergy();


    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]\n", this.id, this.positionRow, this.positionCol);
    }


}
