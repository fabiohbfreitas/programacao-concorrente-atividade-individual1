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

        var client = new Client("Client 1",new Account(bank, 1000), stores);
        client.start();
        var client2 = new Client("Client 2",new Account(bank, 1000), stores);
        client2.start();
        var client3 = new Client("Client 3",new Account(bank, 1000), stores);
        client3.start();
        var client4 = new Client("Client 4",new Account(bank, 1000), stores);
        client4.start();
        var client5 = new Client("Client 5",new Account(bank, 1000), stores);
        client5.start();

        try {
            client.join();
            client2.join();
            client3.join();
            client4.join();
            client5.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        /*
        Since employees do polling to transfer money into investments account and with the current amount of money
        available (5 clients * 1000) not every employee will get paid, this flag signalize that all the clients stopped
        buying and hanging threads (Employees) must finish its work even when they did not get paid.
         */
        bank.finishedAllTransactions.set(true);

        System.out.println("\n");

        bank.printBankInfo();
        client.printAccountInfo();
        client2.printAccountInfo();
        client3.printAccountInfo();
        client4.printAccountInfo();
        client5.printAccountInfo();
        store.printAccountInfo();
        store2.printAccountInfo();
        e1.printAccountStatus();
        e2.printAccountStatus();
        e3.printAccountStatus();
        e4.printAccountStatus();

        var employeeMoney = e1.getAllSavings() + e2.getAllSavings() + e3.getAllSavings() + e4.getAllSavings();
        var storesMoney = store.account.getBalance() + store2.account.getBalance();
        var totalMoney = employeeMoney + storesMoney;
        System.out.println("Total Money on the system: " + totalMoney);
    }
}
