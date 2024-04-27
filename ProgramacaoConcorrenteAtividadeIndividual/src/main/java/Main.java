import Entities.Account;
import Entities.Bank;
import Entities.Client;
import Entities.Store;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var bank = new Bank();

        ArrayList<Store> stores = new ArrayList<>();
        var store = new Store(new Account(bank), "Store 1");
        stores.add(store);

        var client = new Client("Cliente 1",new Account(bank, 1000), stores);
        client.start();

        try {
            client.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(client.account.getBalance());
        System.out.println(store.account.getBalance());
    }
}
