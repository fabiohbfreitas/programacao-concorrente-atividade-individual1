package Entities;

public class Employee extends Thread {
    private String name;

    public Account account;
    public Account investments;

    public Employee(String name, Account account, Account investments) {
        this.name = name;
        this.account = account;
        this.investments = investments;
    }

    public int getAllSavings() {
        return account.getBalance() + investments.getBalance();
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (account.bank.finishedAllTransactions.get()) {
                    break;
                }

                Thread.sleep(450);
                if (account.getBalance() > 0) {
                    System.out.println(this.name + " has received the salary.");
                    var investmentAmount = (int)(account.getBalance() * 0.2);
                    account.bank.transferMoney(account, investments, investmentAmount);
                    break;
                }
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
