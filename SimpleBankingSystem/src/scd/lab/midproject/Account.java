package scd.lab.midproject;

public class Account {
    private int accountId;
    private int userId;
    private int accountNumber;
    private double balance;
    private String accountType;
    private double creditLimit; // for business accounts or overdraft limit for personal accounts

    public Account() {}
    public Account(int accountId, int userId, int accountNumber, double balance, String accountType) {
        this.accountId = accountId;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public int getUserId() {
        return userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void depositAmount(double amount) {
        balance += amount;
    }

    public void withdrawAmount(double amount) throws InsufficientBalanceException{
        // Check for credit limit or balance
        if (balance >= amount) {
            balance -= amount;
        } 
        //else if (amount > balance + creditLimit) {
          //  throw new ExceedsCreditLimitException("Withdrawal amount exceeds credit limit or overdraft limit.");
       // } 
      else if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        }
    }
}
