package _06Animals;

public class Kitten extends Animal {

    public Kitten(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if(!gender.equals("Female")){
            throw new IllegalArgumentException("Invalid input.");
        }
        super.setGender(gender);
    }

    @Override
    protected String produceSound() {
        return "Miau";
    }
}
