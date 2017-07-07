package P09;

public class Tomcat extends Cat {

    Tomcat(String name, int age, String gender) {
        super.setName(name);
        super.setAge(age);
        this.setGender("Male");
    }

    @Override
    public void produceSound() {
        System.out.println("Give me one million b***h");
    }



}
