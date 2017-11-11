package _03WildFarm.animals;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal( String animalName, String animalType, double animalWeight, String livingRegion) {
        super.setAnimalName(animalName);
        super.setAnimalType(animalType);
        super.setAnimalWeight(animalWeight);
        this.setLivingRegion(livingRegion);
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    protected void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAnimalType()).append("[");
        sb.append(this.getAnimalName()).append(", ");
        sb.append(df.format(this.getAnimalWeight())).append(", ");
        sb.append(this.getLivingRegion()).append(", ");
        sb.append(this.getFoodEaten()).append("]");
        return sb.toString();
    }
}
