package _11CatLady;

class Cymric extends BaseCat{
    private double furLength;

    Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f", super.toString(), this.furLength);
    }
}
