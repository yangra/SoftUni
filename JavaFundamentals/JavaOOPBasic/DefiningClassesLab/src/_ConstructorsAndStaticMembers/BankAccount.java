package _ConstructorsAndStaticMembers;

class BankAccount {
    private static double interestRate = 0.02;
    private static int numberOfAccounts = 0;

    private int id;
    private double balance = 0.0;

    public BankAccount() {
        this.id = ++numberOfAccounts;
        System.out.printf("Account ID%d created\n", this.id);
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return years * interestRate * balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            return;
        }
        this.balance += amount;
        System.out.printf("Deposited %.0f to ID%d\n", amount, this.id);
    }

    public int getId() {
        return id;
    }
}
