package _05PizzaCalories;

class Veggies extends BaseIngredient {
    private static final double MODIFIER = 0.8;

    Veggies(int weight) {
        super.setWeight(weight);
    }

    @Override
    double calculateCalories() {
        return (this.weight * BASE_CALORIES_PER_GRAM) * MODIFIER;
    }
}
