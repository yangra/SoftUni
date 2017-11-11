package _03WildFarm.animals;

import _03WildFarm.foods.Food;
import _03WildFarm.foods.Visitor;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    public String getAnimalName() {
        return this.animalName;
    }

    public String getAnimalType() {
        return this.animalType;
    }

    public double getAnimalWeight() {
        return this.animalWeight;
    }

    public int getFoodEaten() {
        return this.foodEaten;
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    protected void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    protected void setAnimalWeight(double animalWeight) {
        this.animalWeight = animalWeight;
    }

    public void eat(Food food, Visitor visitor) {
        this.foodEaten += food.getQuantity();
    }

    public abstract void makeSound();

}
