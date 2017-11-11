package _06Animals;

public class Dog extends Animal {

    public Dog(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected String produceSound() {
        return "BauBau";
    }
}
