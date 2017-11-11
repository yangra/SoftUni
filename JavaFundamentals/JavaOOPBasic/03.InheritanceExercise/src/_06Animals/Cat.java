package _06Animals;

public class Cat extends Animal {
    public Cat(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected String produceSound() {
        return "MiauMiau";
    }
}
