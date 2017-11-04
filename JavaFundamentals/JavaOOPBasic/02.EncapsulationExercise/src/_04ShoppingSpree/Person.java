package _04ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person {
    private String name;
    private double money;
    private List<Product> bag;

    Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bag = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    String getName() {
        return name;
    }

    List<Product> getBag() {
        return Collections.unmodifiableList(bag);
    }

    boolean buyProduct(Product product) {
        if (this.money - product.getCost() >= 0) {
            this.money -= product.getCost();
            this.bag.add(product);
            return true;
        }
        return false;
    }
}
