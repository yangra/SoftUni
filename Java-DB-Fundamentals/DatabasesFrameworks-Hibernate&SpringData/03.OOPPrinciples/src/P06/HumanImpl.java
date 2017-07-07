package P06;


public class HumanImpl implements Human,Identifiable,Birthable {
    private String name;
    private int age;
    private String id;
    private String birthDate;

    HumanImpl(String name, int age, String id, String birthDate) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthDate(birthDate);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
