package P09;

public class Cat extends Animal {

    Cat(){}

    Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("MiauMiau");
    }

}
