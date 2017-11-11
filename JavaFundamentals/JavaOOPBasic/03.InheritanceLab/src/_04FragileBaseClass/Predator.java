package _04FragileBaseClass;

class Predator extends Animal {
    private int health;

    public void feed(Food food){
        super.eat(food);
        this.health++;
    }
}
