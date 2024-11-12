package scd.lab.midproject;

public class Transaction {
    // Transaction details
    private int transactionId;
    private int accountNumber;
    private double amount;
    private String transactionType;
    private String transactionDate;

    // Constructor
    public Transaction(int transactionId, int accountNumber, double amount, String type, String date) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = type;
        this.transactionDate = date;
    }

    // Override toString to format transaction details for file storage
    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
               ", Account Number: " + accountNumber +
               ", Amount: " + amount +
               ", Type: " + transactionType +
               ", Date: " + transactionDate;
    }
}
