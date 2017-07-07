package P09;

public abstract class Animal implements SoundProducible {
    protected String name;
    protected int age;
    protected String gender;

    Animal() {
    }

    Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.name = name;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        }
        this.age = age;
    }

    protected String getGender() {
        return gender;
    }

    protected void setGender(String gender) {
        if (gender.toLowerCase().equals("female") || gender.toLowerCase().equals("male")) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Invalid gender!");
        }

    }

    @Override
    public void produceSound() {
        System.out.println("Not implemented!");
    }

    private String getType() {
        return this.getClass().getName();
    }

    @Override
    public String toString() {
        return this.getType().substring(4) + "\n" + name + " " + age + " " + gender;
    }
}
