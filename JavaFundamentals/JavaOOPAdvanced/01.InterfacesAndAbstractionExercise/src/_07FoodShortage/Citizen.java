package _07FoodShortage;

public class Citizen extends BaseCitizen implements Birthable,Buyer {
    private String name;
    private int age;
    private String birthdate;
    private int food;


    public Citizen(String id, String name, int age, String birthdate) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
        this.food = 0;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
