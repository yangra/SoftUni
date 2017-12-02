package _03CoffeeMachine;

public class Coffee {

    private CoffeeType coffeeType;
    private CoffeeSize coffeeSize;

    public Coffee(CoffeeType coffeeType, CoffeeSize coffeeSize) {
        this.coffeeType = coffeeType;
        this.coffeeSize = coffeeSize;
    }

    @Override
    public String toString() {
        return this.coffeeSize.name().charAt(0) + this.coffeeSize.name().substring(1).toLowerCase() + " "+
                this.coffeeType.name().charAt(0) + this.coffeeType.name().substring(1).toLowerCase();
    }
}
