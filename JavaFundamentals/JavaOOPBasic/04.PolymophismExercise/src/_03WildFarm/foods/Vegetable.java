package _03WildFarm.foods;

public class Vegetable extends Food {
    public Vegetable(int quantity) {
        super(quantity);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
