package P09;


public class Kitten extends Cat {

    Kitten(String name, int age, String gender) {
        super.setName(name);
        super.setAge(age);
        this.setGender("Female");
    }

    @Override
    public void produceSound() {
        System.out.println("Miau");
    }



}
