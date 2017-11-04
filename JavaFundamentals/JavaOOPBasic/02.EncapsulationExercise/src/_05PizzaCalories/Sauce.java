package _05PizzaCalories;

class Sauce extends BaseIngredient {
    private static final double MODIFIER = 0.9;

    Sauce(int weight) {
        super.setWeight(weight);
    }

    @Override
    double calculateCalories() {
        return (this.weight * BASE_CALORIES_PER_GRAM) * MODIFIER;
    }
}
