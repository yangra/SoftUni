package P09;


public class Dog extends Animal{

    Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("BauBau");
    }

}
