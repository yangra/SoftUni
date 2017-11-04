package _05PizzaCalories;

abstract class BaseIngredient {
    static final int BASE_CALORIES_PER_GRAM = 2;

    int weight;

    void setWeight(int weight) {
        if (this.getClass().getSimpleName().equals("Dough") && (weight < 1 || weight > 200)) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        if (!this.getClass().getSimpleName().equals("Dough") && (weight < 1 || weight > 50)) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",
                    this.getClass().getSimpleName()));
        }
        this.weight = weight;
    }

    abstract double calculateCalories();
}
