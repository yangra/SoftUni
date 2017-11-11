package _03WildFarm;

import _03WildFarm.animals.*;
import _03WildFarm.foods.Food;
import _03WildFarm.foods.Meat;
import _03WildFarm.foods.Vegetable;
import _03WildFarm.foods.Visitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();
        while(true){
            String[] animalStr = reader.readLine().split("\\s+");
            if("end".equalsIgnoreCase(animalStr[0])){
                break;
            }

            String type = animalStr[0];
            Animal animal = null;
            if("cat".equalsIgnoreCase(type)){
                animal = new Cat(animalStr[1], type, Double.parseDouble(animalStr[2]),animalStr[3],animalStr[4]);
            }else  if("tiger".equalsIgnoreCase(type)){
                animal = new Tiger(animalStr[1], type, Double.parseDouble(animalStr[2]),animalStr[3]);
            }else if("mouse".equalsIgnoreCase(type)){
                animal = new Mouse(animalStr[1], type, Double.parseDouble(animalStr[2]),animalStr[3]);
            }else if("zebra".equalsIgnoreCase(type)){
                animal = new Zebra(animalStr[1], type, Double.parseDouble(animalStr[2]),animalStr[3]);
            }

            String[] foodStr = reader.readLine().split("\\s+");
            String foodType = foodStr[0];
            Food food = null;
            if("meat".equalsIgnoreCase(foodType)){
                food = new Meat(Integer.parseInt(foodStr[1]));
            }else if("vegetable".equalsIgnoreCase(foodType)){
                food = new Vegetable(Integer.parseInt(foodStr[1]));
            }

            if(animal!=null && food!= null){
                animal.makeSound();
                try {
                    Visitor visitor = new Visitor();
                    animal.eat(food,visitor);
                }catch (IllegalArgumentException iae){
                    System.out.println(iae.getMessage());
                }

                animals.add(animal);
            }
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
