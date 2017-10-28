package _11CatLady;

class StreetExtraordinaire extends BaseCat {
    private double decibelsOfMeows;

    StreetExtraordinaire(String name, double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", super.toString(), this.decibelsOfMeows);
    }
}