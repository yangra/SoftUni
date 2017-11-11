package _03WildFarm.animals;

import _03WildFarm.foods.Food;
import _03WildFarm.foods.Visitor;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    public Cat( String animalName, String animalType, double animalWeight, String livingRegion, String catBreed) {
        super(animalName,animalType,animalWeight,livingRegion);
        this.setBreed(catBreed);
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food, Visitor visitor) {
        super.eat(food, visitor);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAnimalType()).append("[");
        sb.append(this.getAnimalName()).append(", ");
        sb.append(this.breed).append(", ");
        sb.append(df.format(this.getAnimalWeight())).append(", ");
        sb.append(this.getLivingRegion()).append(", ");
        sb.append(this.getFoodEaten()).append("]");
        return sb.toString();
    }
}
