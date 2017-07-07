package P01;

public class Citizen implements Person {
    private String name;
    private int age;

    public Citizen(String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
