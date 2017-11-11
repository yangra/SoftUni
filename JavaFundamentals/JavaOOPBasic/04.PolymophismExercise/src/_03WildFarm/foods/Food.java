package _03WildFarm.foods;

public abstract class Food {
    private int quantity;

    protected Food(int quantity) {
        this.setQuantity(quantity);
    }

    public int getQuantity() {
        return this.quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract void accept(Visitor visitor);
}
