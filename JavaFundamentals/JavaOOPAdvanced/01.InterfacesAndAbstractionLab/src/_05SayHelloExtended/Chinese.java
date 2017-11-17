package _05SayHelloExtended;

public class Chinese extends BasePerson implements Person {
    private String name;

    public Chinese(String name) {
        super(name);
    }


    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
