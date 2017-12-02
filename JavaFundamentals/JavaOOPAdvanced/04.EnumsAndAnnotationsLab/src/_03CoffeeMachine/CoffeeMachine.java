package _03CoffeeMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoffeeMachine {

    private List<Coffee> coffeesSold;
    private List<Coin> money;

    public CoffeeMachine() {
        this.coffeesSold = new ArrayList<>();
        this.money = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        CoffeeSize coffeeSize = CoffeeSize.valueOf(size.toUpperCase());
        CoffeeType coffeeType = CoffeeType.valueOf(type.toUpperCase());
        if (coffeeSize.getPrice() <= this.money.stream().mapToInt(Coin::getValue).sum()){
            Coffee coffee = new Coffee(coffeeType, coffeeSize);
            coffeesSold.add(coffee);
            money.clear();
        }
    }

    public void insertCoin(String coin) {
        money.add(Coin.valueOf(coin.toUpperCase()));
    }

    public Iterable<Coffee> coffeesSold() {
        return Collections.unmodifiableList(this.coffeesSold);
    }

}
