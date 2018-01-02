package app.models.microbes;

import app.models.Cell;
import app.models.Cluster;

public class Bacteria extends Microbe {
    public Bacteria(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    public long getEnergy() {
        return (super.getVirulence() + super.getHealth()) / 3;
    }



    @Override
    public String toString() {
        return super.toString() + String.format("--------Health: %d | Virulence: %d | Energy: %d",
                super.getHealth(), super.getVirulence(), this.getEnergy());
    }
}
