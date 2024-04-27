import Entities.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var bank = new Bank();

        ArrayList<Store> stores = new ArrayList<>();
        var e1 = new Employee("Employee 1", new Account(bank), new Account(bank));
        var e2 = new Employee("Employee 2", new Account(bank), new Account(bank));
        var store = new Store(new Account(bank), "Store 1", e1, e2);
        stores.add(store);

        var e3 = new Employee("Employee 3", new Account(bank), new Account(bank));
        var e4 = new Employee("Employee 4", new Account(bank), new Account(bank));
        var store2 = new Store(new Account(bank), "Store 2", e3, e4);
        stores.add(store2);

        var client = new Client("Cliente 1",new Account(bank, 1000), stores);
        var client2 = new Client("Cliente 2",new Account(bank, 1000), stores);
        client.start();
        client2.start();

        try {
            client.join();
            client2.join();
            bank.finishedAllTransactions.set(true);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(client.account.getBalance());
        System.out.println(client2.account.getBalance());
        System.out.println(store.account.getBalance());
        System.out.println(store2.account.getBalance());
    }
}
