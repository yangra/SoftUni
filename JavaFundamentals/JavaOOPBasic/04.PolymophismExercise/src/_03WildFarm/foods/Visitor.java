package _03WildFarm.foods;

public class Visitor {
    private boolean isMeat;

    public boolean getIsMeat(){
        return this.isMeat;
    }
    void visit(Meat meat){
        this.isMeat = true;
    }

    void visit(Vegetable vegetable){
        this.isMeat = false;
    }
}
