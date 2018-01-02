package hell.entities.miscellaneous;

import hell.factories.ItemFactory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.*;

public class HeroInventory implements Inventory {

    @ItemCollection
    private Map<String, Item> commonItems;

    private Map<String, Recipe> recipeItems;

    public HeroInventory() {
        this.commonItems = new LinkedHashMap<>();
        this.recipeItems = new LinkedHashMap<>();
    }

    @Override
    public long getTotalStrengthBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getStrengthBonus).sum();
    }

    @Override
    public long getTotalAgilityBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getAgilityBonus).sum();
    }

    @Override
    public long getTotalIntelligenceBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getIntelligenceBonus).sum();
    }

    @Override
    public long getTotalHitPointsBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getHitPointsBonus).sum();
    }

    @Override
    public long getTotalDamageBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getDamageBonus).sum();
    }

    @Override
    public void addCommonItem(Item item) {
        this.commonItems.put(item.getName(), item);
        this.checkRecipes();

    }

    @Override
    public void addRecipeItem(Recipe recipe) {

        this.recipeItems.put(recipe.getName(), recipe);
        this.checkRecipes();
    }

    private void checkRecipes() {
        List<String> recipeNames = new ArrayList<>();
        for (Recipe recipe : this.recipeItems.values()) {
            List<String> requiredItems = new ArrayList<>(recipe.getRequiredItems());

            for (Item item : this.commonItems.values()) {
                if (requiredItems.contains(item.getName())) {
                    requiredItems.remove(item.getName());
                }
            }

            if (requiredItems.isEmpty()) {
                this.combineRecipe(recipe);
                recipeNames.add(recipe.getName());
            }
        }

        for (String recipeName : recipeNames) {
            this.recipeItems.remove(recipeName);
        }
    }

    private void combineRecipe(Recipe recipe) {

        for (int i = 0; i < recipe.getRequiredItems().size(); i++) {
            String item = recipe.getRequiredItems().get(i);
            this.commonItems.remove(item);
        }

        //TODO: Initialize the newItem variable, with an object of the CommonItem class.
        //TODO: Initialize the newItem variable, with the stat bonuses of the "recipe" parameter.

        Item newItem = ItemFactory.createCommonItem(recipe.getName(),
                recipe.getStrengthBonus(),
                recipe.getAgilityBonus(),
                recipe.getIntelligenceBonus(),
                recipe.getHitPointsBonus(),
                recipe.getDamageBonus());

        this.commonItems.put(newItem.getName(), newItem);
    }
}