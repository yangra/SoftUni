package hell.entities.heroes;

import hell.entities.miscellaneous.ItemCollection;
import hell.factories.InventoryFactory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public abstract class HeroImpl implements Hero {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

    protected HeroImpl(String name, int strength, int agility, int intelligence, int hitPoints, int damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = InventoryFactory.createHeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    public Collection<Item> getItems() {
        try {
//            Field inventoryField = this.getClass().getSuperclass().getDeclaredField("inventory");
//            inventoryField.setAccessible(true);
//            HeroInventory inventory = (HeroInventory) inventoryField.get(this);
            Field[] inventoryFields = this.inventory.getClass().getDeclaredFields();
            for (Field field : inventoryFields) {
                if (field.isAnnotationPresent(ItemCollection.class)) {
                    field.setAccessible(true);
                    Map<String, Item> map = (Map<String, Item>) field.get(this.inventory);
                    return new ArrayList<>(map.values());
                }
            }
        } catch ( IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

//    Hero: {heroName}, Class: {heroType}
//    HitPoints: {hitpoints}, Damage: {damage}
//    Strength: {strength}
//    Agility: {agility}
//    Intelligence: {intelligence}
//    Items:
//            ###Item: {item1Name}
//###+{strengthBonus} Strength
//###+{agilityBonus} Agility
//###+{intelligenceBonus} Intelligence
//###+{hitpointsBonus} HitPoints
//###+{damageBonus} Damage
//###Item: {item2Name}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hero: ").append(this.getName()).append(", Class: ").append(this.getClass().getSimpleName()).append(System.lineSeparator())
                .append("HitPoints: ").append(this.getHitPoints()).append(", Damage: ").append(this.getDamage()).append(System.lineSeparator())
                .append("Strength: ").append(this.getStrength()).append(System.lineSeparator())
                .append("Agility: ").append(this.getAgility()).append(System.lineSeparator())
                .append("Intelligence: ").append(this.getIntelligence()).append(System.lineSeparator())
                .append("Items:");

        if (this.getItems().size() > 0) {
            sb.append(System.lineSeparator());
            for (Item item : this.getItems()) {
                sb.append("###Item: ").append(item.getName()).append(System.lineSeparator())
                        .append("###+").append(item.getStrengthBonus()).append(" Strength").append(System.lineSeparator())
                        .append("###+").append(item.getAgilityBonus()).append(" Agility").append(System.lineSeparator())
                        .append("###+").append(item.getIntelligenceBonus()).append(" Intelligence").append(System.lineSeparator())
                        .append("###+").append(item.getHitPointsBonus()).append(" HitPoints").append(System.lineSeparator())
                        .append("###+").append(item.getDamageBonus()).append(" Damage").append(System.lineSeparator());
            }
        } else {
            sb.append(" None");
        }

        return sb.toString().trim();
    }


}
