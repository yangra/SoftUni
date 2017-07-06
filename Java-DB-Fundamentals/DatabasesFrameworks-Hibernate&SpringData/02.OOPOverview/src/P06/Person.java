package P06;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private double money;
    private List<Product> bag;

    Person (String name, double money) throws IllegalStateException{
        this.setName(name);
        this.setMoney(money);
        this.bag = new ArrayList<>();
    }

    private void setName(String name) throws IllegalStateException {
        if(name.isEmpty()||name.trim().equals("")){
            System.out.println("Name cannot be empty");
            throw new IllegalStateException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) throws IllegalStateException {
        if(money < 0){
            System.out.println("Money cannot be negative");
            throw new IllegalStateException("Money cannot be negative");
        }
        this.money = money;
    }

    String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    List<Product> getBag() {
        return bag;
    }

    void addToBag(Product product){
        if (this.money >= product.getCost( )) {
            this.bag.add(product);
            this.money -=  product.getCost();
            System.out.printf("%s bought %s\n", this.getName(), product.getName());
        } else {
            System.out.printf("%s can't afford %s\n", this.getName(), product.getName());
        }

    }
}
