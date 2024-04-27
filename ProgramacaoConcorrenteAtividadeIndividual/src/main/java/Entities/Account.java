package Entities;

public class Account {
    private int balance;

    public Account() {
        this.balance = 0;
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
