package _05PizzaCalories;

class Cheese extends BaseIngredient {
    private static final double MODIFIER = 1.1;

    Cheese(int weight) {
        super.setWeight(weight);
    }

    @Override
    double calculateCalories() {
        return (this.weight * BASE_CALORIES_PER_GRAM) * MODIFIER;
    }
}
