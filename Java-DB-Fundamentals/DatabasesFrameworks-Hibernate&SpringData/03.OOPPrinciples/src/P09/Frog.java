package P09;


public class Frog extends Animal {

    Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("Frogggg");
    }

}
