package Entities;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    public Lock lock;
    public AtomicBoolean finishedAllTransactions;

    public Bank() {
        this.lock = new ReentrantLock();
        this.finishedAllTransactions = new AtomicBoolean(false);
    }

    public void transferMoney(Account from, Account to, int amount) {
        lock.lock();
        if (from.makeWithdrawal(amount)) {
            to.makeDeposit(amount);
        }
        lock.unlock();
    }
}
