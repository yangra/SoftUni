package _08May2017.models.monuments;

public abstract class Monument {
    private  String name;

    protected Monument(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }

    public abstract int getAffinity();
}
