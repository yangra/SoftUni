package _05PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Pizza pizza = null;
            Dough dough = null;
            int numberOfToppings = 0;
            for (int i = 0; i < 2; i++) {
                String[] input = reader.readLine().split("\\s+");
                if ("pizza".equalsIgnoreCase(input[0])) {
                    String pizzaName = input[1];
                    numberOfToppings = Integer.parseInt(input[2]);
                    if (numberOfToppings < 0 || numberOfToppings > 10) {
                        throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
                    }
                    pizza = new Pizza(pizzaName);
                } else if ("dough".equalsIgnoreCase(input[0])) {
                    String doughType = input[1];
                    String bakingTechnique = input[2];
                    int weightInGrams = Integer.parseInt(input[3]);
                    dough = new Dough(doughType, bakingTechnique, weightInGrams);
                }
            }

            if (pizza != null && dough != null) {
                pizza.setDough(dough);
            }

            for (int i = 0; i < numberOfToppings; i++) {
                String[] properties = reader.readLine().split("\\s+");
                String topping = properties[1];
                int weight = Integer.parseInt(properties[2]);

                switch (topping.toLowerCase()) {
                    case "meat":
                        BaseIngredient meat = new Meat(weight);
                        pizza.addTopping(meat);
                        break;
                    case "sauce":
                        BaseIngredient sauce = new Sauce(weight);
                        pizza.addTopping(sauce);
                        break;
                    case "veggies":
                        BaseIngredient veggies = new Veggies(weight);
                        pizza.addTopping(veggies);
                        break;
                    case "cheese":
                        BaseIngredient cheese = new Cheese(weight);
                        pizza.addTopping(cheese);
                        break;
                    default:
                        throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", topping));
                }
            }

            System.out.printf("%s - %.2f\n", pizza.getName(), pizza.getCalories());

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
