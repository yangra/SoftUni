package hell.entities.miscellaneous;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class HeroInventoryTest {

    private Inventory inventory;
    private Item item1;
    private Item item2;

    @Before
    public void init(){
        this.inventory = new HeroInventory();
        this.item1 = Mockito.mock(Item.class);
        this.item2 = Mockito.mock(Item.class);
        Mockito.when(item1.getName()).thenReturn("item1");
        Mockito.when(item2.getName()).thenReturn("item2");
        Mockito.when(item1.getStrengthBonus()).thenReturn(2000000000);
        Mockito.when(item2.getStrengthBonus()).thenReturn(2000000000);
        Mockito.when(item1.getAgilityBonus()).thenReturn(2000000000);
        Mockito.when(item2.getAgilityBonus()).thenReturn(2000000000);
        Mockito.when(item1.getIntelligenceBonus()).thenReturn(2000000000);
        Mockito.when(item2.getIntelligenceBonus()).thenReturn(2000000000);
        Mockito.when(item1.getHitPointsBonus()).thenReturn(2000000000);
        Mockito.when(item2.getHitPointsBonus()).thenReturn(2000000000);
        Mockito.when(item1.getDamageBonus()).thenReturn(2000000000);
        Mockito.when(item2.getDamageBonus()).thenReturn(2000000000);
        inventory.addCommonItem(item1);
        inventory.addCommonItem(item2);
    }

    @Test
    public void getTotalStrengthBonus() throws Exception {
        Assert.assertEquals("Doesn't add properly Strength", 4000000000L, inventory.getTotalStrengthBonus());
    }

    @Test
    public void getTotalAgilityBonus() throws Exception {

        Assert.assertEquals("Doesn't add properly Agility", 4000000000L, inventory.getTotalAgilityBonus());
    }

    @Test
    public void getTotalIntelligenceBonus() throws Exception {

        Assert.assertEquals("Doesn't add properly Intelligence", 4000000000L, inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void getTotalHitPointsBonus() throws Exception {

        Assert.assertEquals("Doesn't add properly HitPoints", 4000000000L, inventory.getTotalHitPointsBonus());
    }

    @Test
    public void getTotalDamageBonus() throws Exception {

        Assert.assertEquals("Doesn't add properly Damage", 4000000000L, inventory.getTotalDamageBonus());
    }

    @Test
    public void addCommonItem() throws Exception {
        Field itemsField = this.inventory.getClass().getDeclaredField("commonItems");
        itemsField.setAccessible(true);
        Map<String, Item> items  = (Map<String, Item>) itemsField.get(this.inventory);

        Assert.assertEquals("doesn't add item properly", 2, items.size());
    }

    @Test
    public void addRecipeItem() throws Exception {
        Recipe recipe = Mockito.mock(Recipe.class);
        Mockito.when(recipe.getName()).thenReturn("recipe");
        String[] reqItems = {"item3", "item4"};
        List<String> required = Arrays.asList(reqItems);
        Mockito.when(recipe.getRequiredItems()).thenReturn(required);

        this.inventory.addRecipeItem(recipe);

        Field recipeField = this.inventory.getClass().getDeclaredField("recipeItems");
        recipeField.setAccessible(true);
        Map<String, Recipe> recipes  = (Map<String, Recipe>) recipeField.get(this.inventory);

        Assert.assertEquals("doesn't add recipe properly", 1, recipes.size());
    }

    @Test
    public void checkRecipes() throws Exception {
        Recipe recipe = Mockito.mock(Recipe.class);
        Mockito.when(recipe.getName()).thenReturn("recipe");
        String[] reqItems = {"item1", "item2"};
        List<String> required = Arrays.asList(reqItems);
        Mockito.when(recipe.getRequiredItems()).thenReturn(required);
        this.inventory.addRecipeItem(recipe);

        Field recipesField = this.inventory.getClass().getDeclaredField("recipeItems");
        recipesField.setAccessible(true);
        Map<String, Recipe> recipes  = (Map<String, Recipe>) recipesField.get(this.inventory);
        Field itemsField = this.inventory.getClass().getDeclaredField("commonItems");
        itemsField.setAccessible(true);
        Map<String, Recipe> items  = (Map<String, Recipe>) itemsField.get(this.inventory);

        Assert.assertEquals("doesn't clear recipe properly", 1, recipes.size());
        Assert.assertEquals("doesn't resolve recipe properly", 1, items.size());
    }

    @Test
    public void combineRecipes() throws Exception {
        Recipe recipe1 = Mockito.mock(Recipe.class);
        Mockito.when(recipe1.getName()).thenReturn("recipe1");
        String[] reqItems = {"item1", "item2"};
        List<String> required = Arrays.asList(reqItems);
        Mockito.when(recipe1.getRequiredItems()).thenReturn(required);
        Item item3 = Mockito.mock(Item.class);
        Mockito.when(item3.getName()).thenReturn("item3");
        this.inventory.addRecipeItem(recipe1);
        this.inventory.addCommonItem(item3);

        Field recipesField = this.inventory.getClass().getDeclaredField("recipeItems");
        recipesField.setAccessible(true);
        Map<String, Recipe> recipes  = (Map<String, Recipe>) recipesField.get(this.inventory);
        Field itemsField = this.inventory.getClass().getDeclaredField("commonItems");
        itemsField.setAccessible(true);
        Map<String, Recipe> items  = (Map<String, Recipe>) itemsField.get(this.inventory);

        Assert.assertEquals("doesn't clear recipe properly", 1, recipes.size());
        Assert.assertEquals("doesn't resolve recipe properly", 2, items.size());
    }

}