package app.models.bloodCells;

import app.models.Cell;
import app.models.Cluster;

public abstract class BloodCell extends Cell {

    protected BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    public Cell attack(Cell cell) {
        this.setHealth(this.getHealth() + cell.getHealth());
        return this;
    }
}
