package P05;


public class HumanImpl implements Identifiable,Human {
    private String name;
    private int age;
    private String id;

    HumanImpl(String name, int age, String id) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }
}
