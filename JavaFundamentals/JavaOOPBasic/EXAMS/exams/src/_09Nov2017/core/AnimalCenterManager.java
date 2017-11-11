package _09Nov2017.core;

import _09Nov2017.factories.AnimalFactory;
import _09Nov2017.factories.CenterFactory;
import _09Nov2017.models.animals.Animal;
import _09Nov2017.models.centers.Center;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalCenterManager {
    private Map<String, Center> centers;
    private List<Animal> animals;

    public AnimalCenterManager() {
        this.centers = new HashMap<>();
        this.animals = new ArrayList<>();
    }

    public void registerCleansingCenter(String name) {
        Center center = CenterFactory.createCleansingCenter(name);
        this.centers.put(name, center);
    }

    public void registerAdoptionCenter(String name) {
        Center center = CenterFactory.createAdoptionCenter(name);
        this.centers.put(name, center);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Animal animal = AnimalFactory.createDog(name, age, learnedCommands, adoptionCenterName);
        this.animals.add(animal);
        this.centers.get(adoptionCenterName).addAnimal(animal);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Animal animal = AnimalFactory.createCat(name, age, intelligenceCoefficient, adoptionCenterName);
        this.animals.add(animal);
        this.centers.get(adoptionCenterName).addAnimal(animal);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        Center adoptionCenter = this.centers.get(adoptionCenterName);
        Center cleansingCenter = this.centers.get(cleansingCenterName);
        cleansingCenter.addAllAnimals(adoptionCenter.getAllUncleansed());
        adoptionCenter.removeAllAnimals(adoptionCenter.getAllUncleansed());
    }

    public void cleanse(String cleansingCenterName) {
        List<Animal> animals = this.centers.get(cleansingCenterName).getStoredAnimals();
        for (Animal animal : animals) {
            animal.setCleansingStatus(true);
            this.centers.get(animal.getAdoptionCenter()).addAnimal(animal);
        }
        this.centers.get(cleansingCenterName).removeAllAnimals(animals);
    }

    public void adopt(String adoptionCenterName) {
        this.centers.get((adoptionCenterName)).getAllCleansed().forEach(a -> a.setAdopted(true));
        this.centers.get(adoptionCenterName).removeAllAnimals(
                this.centers.get((adoptionCenterName)).getAllCleansed()
        );

    }

    public void printStatistics() {
        System.out.println("Paw Incorporative Regular Statistics");
        System.out.printf("Adoption Centers: %s\n", this.centers.values().stream().filter(a -> a.getClass().getSimpleName().equals("AdoptionCenter")).count());
        System.out.printf("Cleansing Centers: %s\n", this.centers.values().stream().filter(a -> a.getClass().getSimpleName().equals("CleansingCenter")).count());
        System.out.println("Adopted Animals: " + (
                this.animals.stream().filter(a -> a.isAdopted()).count() > 0 ?
                        this.animals.stream().filter(a -> a.isAdopted()).map(a -> a.getName()).sorted().collect(Collectors.joining(", "))
                        : "None"));
        System.out.println("Cleansed Animals: " + (
                this.animals.stream().filter(a -> a.getCleansingStatus()).count() > 0 ?
                        this.animals.stream().filter(a -> a.getCleansingStatus()).map(a -> a.getName()).sorted().collect(Collectors.joining(", "))
                        : "None"));
        System.out.printf("Animals Awaiting Adoption: %s\n", this.animals.stream().filter(a -> !a.isAdopted() && a.getCleansingStatus()).count());
        System.out.printf("Animals Awaiting Cleansing: %s\n", this.centers.values().stream().filter(c -> c.getClass().getSimpleName().equalsIgnoreCase("cleansingcenter")).mapToInt(c -> c.getStoredAnimals().size()).sum());
    }


    public void registerCastrationCenter(String name) {
        Center center = CenterFactory.createCastrationCenter(name);
        this.centers.put(name, center);
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        this.centers.get(castrationCenterName).addAllAnimals(this.centers.get(adoptionCenterName).getAllUncleansed());
        this.centers.get(adoptionCenterName).removeAllAnimals(this.centers.get(adoptionCenterName).getAllUncleansed());
    }

    public void castrate(String castrationCenterName) {
        for (Animal animal : this.centers.get(castrationCenterName).getStoredAnimals()) {
            animal.setCastrationStatus(true);
            this.centers.get(animal.getAdoptionCenter()).addAnimal(animal);
        }
        this.centers.get(castrationCenterName).removeAllAnimals(this.centers.get(castrationCenterName).getStoredAnimals());
    }

    public void castrationStatistics() {
        System.out.println("Paw Inc. Regular Castration Statistics");
        System.out.printf("Castration Centers: %d\n",
                this.centers.values().stream()
                        .filter(c -> c.getClass().getSimpleName().equalsIgnoreCase("castrationcenter"))
                        .count());
        System.out.printf("Castrated Animals: %s\n",
                (animals.stream().filter(Animal::getCastrationStatus).count() > 0 ?
                        animals.stream()
                                .filter(Animal::getCastrationStatus)
                                .map(Animal::getName)
                                .sorted()
                                .collect(Collectors.joining(", "))
                        : "None"));
    }
}


