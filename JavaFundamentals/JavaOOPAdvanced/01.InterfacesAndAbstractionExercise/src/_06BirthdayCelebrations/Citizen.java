package _06BirthdayCelebrations;

public class Citizen extends BaseResident implements Birthable {
    private String name;
    private int age;
    private String birthdate;


    public Citizen(String id, String name, int age, String birthdate) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

}
