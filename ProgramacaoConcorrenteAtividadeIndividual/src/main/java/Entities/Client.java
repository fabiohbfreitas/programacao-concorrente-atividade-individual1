package Entities;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Client extends Thread {
    private String name;
    public Account account;
    private ArrayList<Store> stores;

    public Client(String name, Account account, ArrayList<Store> stores) {
        this.name = name;
        this.account = account;
        this.stores = stores;
    }


    @Override
    public void run() {
        while (account.getBalance() > 0) {
            var store = stores.get(ThreadLocalRandom.current().nextInt(stores.size()));
            var amount = ThreadLocalRandom.current().nextBoolean() ? 100 : 200;
            if (account.getBalance() < amount) {
                continue;
            }
            store.buy(this, amount);
            System.out.println(this.name + " | bought from "+ store.name +" costing " + amount);
            try {
                Thread.sleep(500 + ThreadLocalRandom.current().nextInt(500));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void printAccountInfo() {
        System.out.println(this.name + " has " + account.getBalance() + " on account balance.");
    }
}
