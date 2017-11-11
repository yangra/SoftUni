package _09Nov2017.models.animals;

public class Cat extends Animal {
    private int intelligenceCoefficient;

    public Cat(String name, int age, int intelligenceCoefficient, String adoptionCenter) {
        super(name, age);
        this.intelligenceCoefficient = intelligenceCoefficient;
        super.setAdoptionCenter(adoptionCenter);
    }

}
