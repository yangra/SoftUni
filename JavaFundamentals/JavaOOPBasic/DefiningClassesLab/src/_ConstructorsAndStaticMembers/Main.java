package _ConstructorsAndStaticMembers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, BankAccount> accounts = new HashMap<>();
        while (true) {
            String[] command = reader.readLine().split(" ");
            if ("end".equalsIgnoreCase(command[0])) {
                break;
            }

            switch (command[0]) {
                case "Create":
                    BankAccount acc = new BankAccount();
                    accounts.put(acc.getId(),acc);
                    break;
                case "Deposit":
                    int id = Integer.parseInt(command[1]);
                    double amount = Double.parseDouble(command[2]);
                    deposit(id, amount, accounts);
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(command[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(command[1]);
                    int years = Integer.parseInt(command[2]);
                    getInterest(id,years, accounts);
                    break;
            }
        }

    }

    private static void getInterest(int id, int years, HashMap<Integer, BankAccount> accounts) {
        if(accounts.containsKey(id)){
            System.out.printf("%.2f\n",accounts.get(id).getInterest(years));
        }else{
            System.out.println("Account does not exist");
        }
    }

    private static void deposit(int id, double amount, HashMap<Integer, BankAccount> accounts) {
        if(accounts.containsKey(id)){
            accounts.get(id).deposit(amount);
        }else {
            System.out.println("Account does not exist");
        }
    }
}

