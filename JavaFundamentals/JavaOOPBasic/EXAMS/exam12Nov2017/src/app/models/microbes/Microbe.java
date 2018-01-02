package app.models.microbes;

import app.models.Cell;
import app.models.Cluster;

public abstract class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    public int getVirulence() {
        return this.virulence;
    }


    @Override
    public Cell attack(Cell nextCell) {

        while (true) {
            nextCell.setHealth(nextCell.getHealth() - this.getEnergy());
            if (nextCell.getHealth() <= 0) {
                return this;
            }
            this.setHealth(this.getHealth() - nextCell.getEnergy());
            if (this.getHealth() <= 0) {
                return nextCell;
            }
        }

    }
}
