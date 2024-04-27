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

    public void printAccountStatus() {
        System.out.println(
                this.name + " has " + this.account.getBalance()
                        + " on acount and "
                        + this.investments.getBalance() + " on investments."
        );
    }

    public int getAllSavings() {
        return this.account.getBalance() + this.investments.getBalance();
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (account.bank.finishedAllTransactions.get()) {
                    System.out.println(this.name + " did not get paid.");
                    break;
                }

                Thread.sleep(450);

                if (account.getBalance() > 0) {
                    var investmentAmount = (int)(account.getBalance() * 0.2);
                    account.bank.transferMoney(account, investments, investmentAmount);
                    System.out.println(this.name + " has received the salary.");
                    break;
                }
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
