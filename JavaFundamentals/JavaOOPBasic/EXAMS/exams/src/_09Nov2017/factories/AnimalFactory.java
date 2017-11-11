package _09Nov2017.factories;

import _09Nov2017.models.animals.Animal;
import _09Nov2017.models.animals.Cat;

public final class AnimalFactory {
    private AnimalFactory(){}

    public static Animal createCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName){
       return new Cat(name, age, intelligenceCoefficient,adoptionCenterName);
    }

    public static Animal createDog(String name, int age, int numberOfCommands, String adoptionCenterName){
        return new Cat(name, age, numberOfCommands,adoptionCenterName);
    }
}
