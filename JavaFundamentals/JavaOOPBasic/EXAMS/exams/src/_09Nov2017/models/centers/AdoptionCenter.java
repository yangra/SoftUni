package _09Nov2017.models.centers;

import _09Nov2017.models.animals.Animal;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    @Override
    public List<Animal> getAllUncleansed(){
        return super.getStoredAnimals().stream().filter(a->!a.getCleansingStatus()).collect(Collectors.toList());
    }

    @Override
    public List<Animal> getAllCleansed(){
        return Collections.unmodifiableList(super.getStoredAnimals().stream().filter(Animal::getCleansingStatus).collect(Collectors.toList()));
    }
}
