package de.dhbwka.java.exercise.classes;

public class Account {
    int accountNumber;
    String name;
    double balance;
    double limit;

    Account(int accountNumber, String name, double limit){
        this.accountNumber = accountNumber;
        this.name = name;
        this.limit = limit;
        this.balance = 0;
    }

    Account(int accountNumber, String name, double balance, double limit){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.limit = limit;
    }

    public void balanceAdd(int amount){
        this.balance += amount;
    }

    public void payout(int amount){
        if (balance-amount > -limit) this.balance -= amount;
        else System.out.println("limit reached!");
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", limit=" + limit +
                '}';
    }

    public static void main(String[] args) {
        Account account = new Account(4711, "Donald Duck", 500, 1000);
        System.out.println(account);
        account.balanceAdd(200);
        System.out.println(account);
        account.payout(400);
        System.out.println(account);
        account.payout(2000);
        System.out.println(account);
    }
}
