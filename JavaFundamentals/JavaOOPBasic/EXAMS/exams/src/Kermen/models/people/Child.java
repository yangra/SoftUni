package Kermen.models.people;

import Kermen.models.items.Toy;

import java.util.Collections;
import java.util.List;

public class Child {
    private double foodCost;
    private List<Toy> toys;

    public Child(double foodCost, List<Toy> toys) {
        this.foodCost = foodCost;
        this.toys = toys;
    }

    public double getFoodCost() {
        return this.foodCost;
    }

    public List<Toy> getToys() {
        return Collections.unmodifiableList(this.toys);
    }
}
