package org.doctorajan;

public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful, Current balance is " + balance + ".");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful, Current balance is " + balance + ".");
        }
        else {
            System.out.println("Insufficient funds");
        }
    }

    public double getBalance() {
        System.out.println("Balance is " + balance);
        return balance;
    }
}
