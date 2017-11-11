package _09Nov2017.models.animals;

public class Dog extends Animal {
    private int amountOfCommands;


    public Dog(String name, int age, int amountOfCommands, String adoptionCenter) {
        super(name, age);
        this.amountOfCommands = amountOfCommands;
        super.setAdoptionCenter(adoptionCenter);

    }

}
