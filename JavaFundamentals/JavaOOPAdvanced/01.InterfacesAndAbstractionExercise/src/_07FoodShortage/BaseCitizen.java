package _07FoodShortage;

public abstract class BaseCitizen implements Identifiable {
    private String id;

    protected BaseCitizen(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
