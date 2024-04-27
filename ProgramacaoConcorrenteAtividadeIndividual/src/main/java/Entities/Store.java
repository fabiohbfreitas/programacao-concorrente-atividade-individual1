package Entities;

public class Store {
    public Account account;
    public String name;

    public Store(Account account, String name) {
        this.account = account;
        this.name = name;
    }

    public void buy(int amount) {

        if (account.getBalance() >= 1400) {
            payEmployees();
        }
    }

    private void payEmployees() {

    }
}
