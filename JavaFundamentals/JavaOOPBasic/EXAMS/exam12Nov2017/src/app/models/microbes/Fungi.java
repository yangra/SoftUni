package app.models.microbes;

public class Fungi extends Microbe {
    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    public long getEnergy(){
       return (super.getVirulence() + super.getHealth()) / 4;
    }

    @Override
    public String toString() {
        return super.toString()+  String.format("--------Health: %d | Virulence: %d | Energy: %d",
                super.getHealth(), super.getVirulence(), this.getEnergy() );
    }
}
