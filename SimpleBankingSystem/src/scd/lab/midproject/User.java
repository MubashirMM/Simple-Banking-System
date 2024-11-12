package scd.lab.midproject;

import java.io.FileWriter;
import java.util.*;

public class User {

	// User details 
	private String userName;
	private int userId;
	private int password;
	private String email;
	private String address;
	private List<Account> accounts;
	protected TransactionHistory transactionHistory;
	private Scanner input = new Scanner(System.in);

	// Constructors
	public User() {
	}

	public User(int userId, String userName, String email, String address, int password) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.password = password;
		accounts = new ArrayList<>();
		transactionHistory = new TransactionHistory(userId);
	}

	// Create a business account
	public void createBusinessAccount(int accountId, int accountNumber, double initialBalance, double creditLimit) {
		BussinessAccount newBAccount = new BussinessAccount(accountId, userId, accountNumber, initialBalance, creditLimit);
		accounts.add(newBAccount);
		System.out.println("\u001B[32m" + "Business Account created successfully!");
	}

	// Create a personal account
	public void createPersonalAccount(int accountId, int accountNumber, double balance, double overDraftLimit) {
		PersonelAccount newPAccount = new PersonelAccount(accountId, userId, accountNumber, balance, overDraftLimit);
		accounts.add(newPAccount);
		System.out.println("\u001B[32m" + "Personal Account created successfully!");
	}

	// Deposit money into an account
	public void deposit(int userId, double amount) throws InsufficientBalanceException {
		for (Account account : accounts) {
			if (this.userId == userId) {
				System.out.println("Enter TransactionId: ");
				int transactionId = input.nextInt();
				System.out.println("Enter date: ");
				String date = input.next();

				Transaction newTransaction = new Transaction(transactionId, account.getAccountNumber(), amount, "deposit", date);
				transactionHistory.addTransaction(newTransaction);

				account.depositAmount(amount);
				System.out.println("\u001B[32m" + "Deposit successful!");
				return;
			}
		}
		errorLog("Deposit failed. No account found with User ID: " + userId);
		System.out.println("\u001B[31m" + "Deposit failed. No account found with User ID: " + userId);
	}

	// Withdraw money from an account
	public void withdraw(int userId, double amount) throws InsufficientBalanceException {
		for (Account account : accounts) {
			if (this.userId == userId) {
				account.withdrawAmount(amount);
				System.out.println("Enter TransactionId: ");
				int transactionId = input.nextInt();
				System.out.println("Enter date: ");
				String date = input.next();

				Transaction newTransaction = new Transaction(transactionId, account.getAccountNumber(), amount, "withdrawal", date);
				transactionHistory.addTransaction(newTransaction);

				System.out.println("\u001B[32m" + "Withdrawal successful!");
				return;
			}
		}
		errorLog("Withdrawal failed. No account found with User ID: " + userId);
		System.out.println("\u001B[31m" + "Withdrawal failed. No account found with User ID: " + userId);
	}

	// Error log function
	public void errorLog(String message) {
		try (FileWriter writer = new FileWriter("Error.log", true)) {
			writer.write(message + "\n");
		} catch (Exception e) {
			System.out.println("Error in creating Error Log!");
		}
	}
	
	//view transaction history
	public void viewTransactionHistory() {
		System.out.println("\nTransaction History:");
		transactionHistory.viewTransactionHistoryFromFile();
	}
	
	public void displayUserDetails() {
        System.out.println("User Details:");
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
    }
	
}