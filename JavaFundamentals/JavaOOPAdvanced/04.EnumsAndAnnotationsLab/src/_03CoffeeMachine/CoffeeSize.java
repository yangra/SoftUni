package _03CoffeeMachine;

public enum CoffeeSize {
    SMALL (50, 50), NORMAL (100, 75), DOUBLE (200, 100);

    private int quantity;
    private int price;

    CoffeeSize(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
