package _03WildFarm.animals;

import _03WildFarm.foods.Food;
import _03WildFarm.foods.Meat;
import _03WildFarm.foods.Visitor;

public class Tiger extends Feline {
    private String livingRegion;

    public Tiger( String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName,animalType,animalWeight,livingRegion);
        this.livingRegion = livingRegion;
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food, Visitor visitor) {
        food.accept(visitor);
        if(!visitor.getIsMeat()){
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.eat(food, visitor);
    }
}
