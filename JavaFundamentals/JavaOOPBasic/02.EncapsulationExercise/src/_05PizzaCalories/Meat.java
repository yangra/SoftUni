package _05PizzaCalories;

class Meat extends BaseIngredient {
    private static final double MODIFIER = 1.2;

    Meat(int weight) {
        super.setWeight(weight);
    }

    @Override
    double calculateCalories() {
        return (this.weight * BASE_CALORIES_PER_GRAM) * MODIFIER;
    }
}
