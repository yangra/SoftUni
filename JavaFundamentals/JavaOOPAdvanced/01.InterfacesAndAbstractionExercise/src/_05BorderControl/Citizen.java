package _05BorderControl;

public class Citizen extends BaseResident {
    private String name;
    private int age;


    public Citizen(String id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }

}
