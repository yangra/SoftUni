package _03WildFarm.animals;

import _03WildFarm.foods.Food;
import _03WildFarm.foods.Vegetable;
import _03WildFarm.foods.Visitor;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food, Visitor visitor) {
        food.accept(visitor);
        if (visitor.getIsMeat()) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.eat(food,visitor);
    }
}
