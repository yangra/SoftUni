package _05PizzaCalories;

import java.util.ArrayList;
import java.util.List;

class Pizza {


    private String name;
    private Dough dough;
    private List<BaseIngredient> toppings;

    Pizza(String name) {
        this.setName(name);
        this.toppings = new ArrayList<>();
    }

    String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    void setDough(Dough dough) {
        this.dough = dough;
    }

    void addTopping(BaseIngredient topping) {
        this.toppings.add(topping);
    }

    double getCalories() {
        double totalCalories = 0;
        totalCalories += this.dough.calculateCalories();
        for (BaseIngredient topping : this.toppings) {
            totalCalories += topping.calculateCalories();
        }
        return totalCalories;
    }

}
