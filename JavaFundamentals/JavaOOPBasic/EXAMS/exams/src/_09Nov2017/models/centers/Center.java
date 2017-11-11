package _09Nov2017.models.centers;

import _09Nov2017.models.animals.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Center {
    private String name;
    private List<Animal> storedAnimals;

    protected Center(String name) {
        this.name = name;
        this.storedAnimals = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Animal> getStoredAnimals() {
        return Collections.unmodifiableList(this.storedAnimals);
    }

    public void addAllAnimals(List<Animal> animals){
        this.storedAnimals.addAll(animals);
    }

    public void removeAllAnimals(List<Animal> animals){
        this.storedAnimals.removeAll(animals);
    }

    public void addAnimal(Animal animal){
        this.storedAnimals.add(animal);
    }

    public List<Animal> getAllUncleansed(){return new ArrayList<>();}

    public List<Animal> getAllCleansed(){return new ArrayList<>();}
}
