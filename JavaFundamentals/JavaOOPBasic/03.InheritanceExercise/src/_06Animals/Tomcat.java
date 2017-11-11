package _06Animals;

public class Tomcat extends Animal {

    public Tomcat(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if(!gender.equals("Male")){
            throw new IllegalArgumentException("Invalid input.");
        }
        super.setGender(gender);
    }

    @Override
    protected String produceSound() {
        return "Give me one million b***h";
    }
}
