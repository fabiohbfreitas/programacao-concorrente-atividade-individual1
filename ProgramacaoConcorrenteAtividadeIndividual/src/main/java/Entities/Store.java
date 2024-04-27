package Entities;

import java.util.ArrayList;

public class Store {
    public Account account;
    public String name;

    private Employee firstEmployee;
    private Employee secondEmployee;

    private ArrayList<Employee> paidEmployees;

    public Store(Account account, String name, Employee firstEmployee, Employee secondEmployee) {
        this.account = account;
        this.name = name;
        this.firstEmployee = firstEmployee;
        this.secondEmployee = secondEmployee;
        this.paidEmployees = new ArrayList<>();

        firstEmployee.start();
        secondEmployee.start();
    }

    public void buy(Client from, int amount) {
        account.bank.transferMoney(from.account, this.account, amount);
        if (account.getBalance() >= 1400) {
            payEmployees();
        }
    }

    private void payEmployees() {
        if (paidEmployees.size() == 2) return;
        if (paidEmployees.contains(firstEmployee)) {
            account.bank.transferMoney(account, secondEmployee.account, 1400);
        } else {
            account.bank.transferMoney(account, firstEmployee.account, 1400);
            paidEmployees.add(firstEmployee);
        }
    }

    public void printAccountInfo() {
        System.out.println(this.name + " has " + this.account.getBalance() + " on account balance.");
    }
}
