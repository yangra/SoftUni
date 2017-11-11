package _06Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, String age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(String age) {
        try {
            if (Integer.valueOf(age) < 0) {
                throw new IllegalArgumentException("Invalid input!");
            }
            this.age = Integer.parseInt(age);
        }catch (NumberFormatException nfe){
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public String getGender() {
        return this.gender;
    }

    protected void setGender(String gender) {
        if(!gender.equals("Female")&&!gender.equals("Male")){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    protected String produceSound() {
        return "Not implemented.";
    }

    @Override
    public String toString() {
        return String.format("%s\n%s %d %s\n%s",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getAge(),
                this.getGender(),
                this.produceSound());
    }
}
