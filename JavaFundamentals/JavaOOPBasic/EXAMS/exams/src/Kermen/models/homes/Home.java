package Kermen.models.homes;

public abstract class Home {
    private double budget;

    public Home() {
        budget = 0;
    }

    public double getBudget() {
        return this.budget;
    }

    protected void setBudget(double budget) {
        this.budget = budget;
    }

    public abstract void payIncome();

    public abstract double getConsumption();

    public abstract double getRoomConsumption();

    public void payBills() {
        this.budget = this.budget - this.getConsumption();
    }


    public abstract int getNumberOfPeople();
}
