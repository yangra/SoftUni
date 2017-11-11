package _03WildFarm.foods;

public class Meat extends Food {

    public Meat(int quantity) {
        super(quantity);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
