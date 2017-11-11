package _06Animals;

public class Frog extends  Animal {

    public Frog(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected String produceSound() {
        return "Frogggg";
    }
}
