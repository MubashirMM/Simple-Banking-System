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
	private TransactionHistory transactionHistory;
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

	// Create an account
	public void createAccount(int accountId, int accountNumber, double initialBalance, String accountType) throws InvalidAccountNumberException {
		
		if(accountNumber<=0) {
			throw new InvalidAccountNumberException("Invalid Account Number Exception!"); 
		}
		else {
		Account newAccount = new Account(accountId, userId, accountNumber, initialBalance, accountType);
		accounts.add(newAccount);
		System.out.println("\u001B[32m" + "Congrats! " + accountType + " Account created successfully!");
		}
	} 

	// Deposit money into an account
	public void deposit(int userId, double amount) {
		for (Account account : accounts) {
			if (this.userId == userId) {
				System.out.println("Enter TransactionId: ");
				int transactionId = input.nextInt();
				System.out.println("Enter date: ");
				String date = input.next();

				Transaction newTransaction = new Transaction(transactionId, account.getAccountNumber(), amount,
						"deposit", date);
				transactionHistory.addTransaction(newTransaction);
 
				account.depositAmount(amount);
				System.out.println("\u001B[32m" + "Deposit successfuly!");
				return;
			}
		}
		errorLog("\u001B[31m" + "Deposit failed. No account found with User ID: " + userId);
		System.out.println("\u001B[31m" + "Deposit failed. No account found with User ID: " + userId);
	}

	// Withdraw money from an account 
	public void withdraw(int userId, double amount) {
		for (Account account : accounts) {
			if (this.userId == userId) {
				try {
					
					// This should throw an exception if insufficient balance
					account.withdrawAmount(amount); 
					System.out.println("Enter TransactionId: ");
					int transactionId = input.nextInt();
					System.out.println("Enter date: ");
					String date = input.next();

					//performing new transaction
					Transaction newTransaction = new Transaction(transactionId, account.getAccountNumber(), amount,
							"withdrawal", date);
					transactionHistory.addTransaction(newTransaction);

					System.out.println("\u001B[32m" + "Withdrawal successfuly!");
					return;
					
				} catch (InsufficientBalanceException e) {
					errorLog("Withdrawal failed for User ID: " + userId + ", Amount: " + amount + " - " + e.getMessage());
					System.out.println("\u001B[31m" + "Error: " + e.getMessage());
					return;
				}
			}
		}
		errorLog("\u001B[31m" + "Withdrawal failed. No account found with User ID: " + userId);
		System.out.println("\u001B[31m" + "Withdrawal failed. No account found with User ID: " + userId);
	}

	// Display a user details
	public void displayUserDetails() {
		System.out.println("\u001B[33m" + "Name: " + userName);
		System.out.println("ID: " + userId);
		System.out.println("Email: " + email);
		System.out.println("Address: " + address);
	}

	// Display account details for this user
	public void displayAccountDetails() {
		System.out.println("\u001B[35m" + "Account Details:");
		for (Account account : accounts) {
			System.out.println("Account ID: " + account.getAccountId());
			System.out.println("Account Number: " + account.getAccountNumber());
			System.out.println("Current Balance: " + account.getBalance());
			System.out.println("Account Type: " + account.getAccountType());
			System.out.println();
		}
	}

	//error log funtion for errors to write in file
	public void errorLog(String message) {
		try(FileWriter writer=new FileWriter(("Error.log"),true)){
			writer.write(message+"\n");
		}catch(Exception e){
			System.out.println("Error in creating Error Log!");
		}
	}
	
	// View transaction history for this user
	public void viewTransactionHistory() {
		System.out.println("\nTransaction History:");
		transactionHistory.viewTransactionHistoryFromFile();
	}
}
