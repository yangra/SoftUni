package _DefiningClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();
        while (true) {
            String[] command = reader.readLine().split(" ");
            if ("end".equalsIgnoreCase(command[0])) {
                break;
            }

            switch (command[0]) {
                case "Create":
                    int id= Integer.parseInt(command[1]);
                    createBankAccount(id,bankAccounts);
                    break;
                case "Deposit":
                    id= Integer.parseInt(command[1]);
                    double amount = Double.parseDouble(command[2]);
                    deposit(id,amount, bankAccounts);
                    break;
                case "Withdraw":
                    id= Integer.parseInt(command[1]);
                    amount = Double.parseDouble(command[2]);
                    withdraw(id,amount, bankAccounts);
                    break;
                case "Print":
                    id= Integer.parseInt(command[1]);
                    print(id, bankAccounts);
                    break;
            }
        }

    }

    private static void print(int id, HashMap<Integer, BankAccount> bankAccounts) {
        if(bankAccounts.containsKey(id)){
            System.out.println(bankAccounts.get(id));
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void withdraw(int id, double amount, HashMap<Integer, BankAccount> bankAccounts) {
        if(bankAccounts.containsKey(id)){
            bankAccounts.get(id).withdraw(amount);
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void deposit(int id, double amount, HashMap<Integer, BankAccount> bankAccounts) {
        if(bankAccounts.containsKey(id)){
            bankAccounts.get(id).deposit(amount);
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void createBankAccount(int id, HashMap<Integer, BankAccount> accounts) {
        if(accounts.containsKey(id)){
            System.out.println("Account already exists");
            return;
        }
        BankAccount account = new BankAccount(id);
        accounts.put(id, account);
    }
}
