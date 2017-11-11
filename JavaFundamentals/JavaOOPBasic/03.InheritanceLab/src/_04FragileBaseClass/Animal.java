package _04FragileBaseClass;

import java.util.Collections;
import java.util.List;

public class Animal {
    protected List<Food> foodEaten;

    final void eat(Food food){
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] foods){
        Collections.addAll(this.foodEaten,foods);
    }
}
