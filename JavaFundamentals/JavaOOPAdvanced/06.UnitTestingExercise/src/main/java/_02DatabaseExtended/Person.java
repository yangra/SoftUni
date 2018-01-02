package _02DatabaseExtended;

public class Person {

    private long id;
    private String username;

    public Person(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Person(String username) {
        this.username = username;
    }

    public long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }
}
