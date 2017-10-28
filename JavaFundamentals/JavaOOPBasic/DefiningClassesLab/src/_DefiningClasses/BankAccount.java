package _DefiningClasses;

class BankAccount {
    private int id;
    private double balance;

    public BankAccount(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void deposit(double amount){
        if(amount<0){
            return;
        }
        balance += amount;
    }

    public void withdraw(double amount){
        if(balance-amount<0){
            System.out.println("Insufficient balance");
            return;
        }
        balance-=amount;
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f",this.id, this.balance);
    }
}
