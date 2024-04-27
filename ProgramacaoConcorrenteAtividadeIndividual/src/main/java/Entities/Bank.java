package Entities;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    public Lock lock;
    public AtomicBoolean finishedAllTransactions;

    private int transactedMoney;
    private int totalTransactions;

    public Bank() {
        this.lock = new ReentrantLock();
        this.finishedAllTransactions = new AtomicBoolean(false);
        this.transactedMoney = 0;
    }

    public void transferMoney(Account from, Account to, int amount) {
        if (finishedAllTransactions.get()) {
            return;
        }
        lock.lock();
        if (from.makeWithdrawal(amount)) {
            to.makeDeposit(amount);
            transactedMoney += amount;
            totalTransactions += 1;
        }
        lock.unlock();
    }

    public void printBankInfo() {
        if (!finishedAllTransactions.get()) {
            return;
        }
        System.out.println("-- Total Bank Transactions: " + totalTransactions);
        System.out.println("-- Total Transacted Money: " + transactedMoney);
    }
}
