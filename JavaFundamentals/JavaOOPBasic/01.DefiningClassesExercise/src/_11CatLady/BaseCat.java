package _11CatLady;

abstract class BaseCat {
    private String name;

    BaseCat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
}
