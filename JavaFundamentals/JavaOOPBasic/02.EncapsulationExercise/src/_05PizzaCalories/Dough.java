package _05PizzaCalories;

class Dough extends BaseIngredient {
    private static final double TYPE_MODIFIER_WHITE = 1.5;
    private static final double TYPE_MODIFIER_WHOLEGRAIN = 1.0;
    private static final double PROPERTY_MODIFIER_CRISPY = 0.9;
    private static final double PROPERTY_MODIFIER_CHEWY = 1.1;
    private static final double PROPERTY_MODIFIER_HOMEMADE = 1.0;

    private String type;
    private String property;

    Dough(String type, String property, int weight) {
        this.setType(type);
        this.setProperty(property);
        super.setWeight(weight);

    }

    private double getTypeModifier() {
        if ("white".equalsIgnoreCase(this.type)) {
            return TYPE_MODIFIER_WHITE;
        }
        return TYPE_MODIFIER_WHOLEGRAIN;
    }

    private double getPropertyModifier() {
        if ("crispy".equalsIgnoreCase(this.property)) {
            return PROPERTY_MODIFIER_CRISPY;
        }
        if ("chewy".equalsIgnoreCase(this.property)) {
            return PROPERTY_MODIFIER_CHEWY;
        }
        return PROPERTY_MODIFIER_HOMEMADE;
    }

    private void setType(String type) {
        if (!"white".equalsIgnoreCase(type) && !"wholegrain".equalsIgnoreCase(type)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.type = type;
    }

    private void setProperty(String property) {
        if (!"chewy".equalsIgnoreCase(property) && !"crispy".equalsIgnoreCase(property) &&
                !"homemade".equalsIgnoreCase(property)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.property = property;
    }


    @Override
    double calculateCalories() {
        return (this.weight * BASE_CALORIES_PER_GRAM) * this.getTypeModifier() * this.getPropertyModifier();
    }
}
