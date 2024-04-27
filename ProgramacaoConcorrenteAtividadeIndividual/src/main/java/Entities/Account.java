package Entities;

public class Account {
    public Bank bank;
    private int balance;


    public Account(Bank bank, int balance) {
        this.balance = balance;
        this.bank = bank;
    }

    public Account(Bank bank) {
        this.bank = bank;
        this.balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public void makeDeposit(int amount) {
        balance += amount;
    }

    public boolean makeWithdrawal(int amount) {
        if (balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }
}
