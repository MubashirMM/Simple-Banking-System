package scd.lab.midproject;

public class Transaction {
	// variables and default values
	int transactionId = 000;
	int accountNumber = 000;
	double amount = 000;
	String transactionType = "deposit or witdraewal";
	String transactionDate = "11/1/1";

	// default constructor
	Transaction() {
	}

	// perametrized constructor
	Transaction(int transactionId, int accountNumber, double amount, String type, String date) {
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.transactionType = type;
		this.transactionDate = date;
	}

	@Override
	public String toString() {
	    return "Transaction ID: " + transactionId + ", Account Number: " + accountNumber +
	           ", Amount: " + amount + ", Type: " + transactionType + ", Date: " + transactionDate;
	}

} 
