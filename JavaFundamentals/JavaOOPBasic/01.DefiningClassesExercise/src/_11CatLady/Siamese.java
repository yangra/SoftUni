package _11CatLady;

class Siamese extends BaseCat {
    private double earSize;

    Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", super.toString(), this.earSize);
    }
}
