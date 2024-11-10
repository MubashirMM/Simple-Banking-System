package scd.lab.midproject;

import java.util.*;

public class Bank {

	// Variables with default values
	private String name = "Haider Bank Limited";
	private int id = 12345;
	private List<BussinessUser> Busers;
	private List<IndividualUser> Iusers;

	// Default constructor
	public Bank() {
		Busers = new ArrayList<>();
		Iusers = new ArrayList<>();
	}

	// Parameterized constructor
	public Bank(String name, int id) {
		this.name = name;
		this.id = id;
		Busers = new ArrayList<>();
		Iusers = new ArrayList<>();
	}

	// Add Business User
	public void addBussinessUser(String userName, int userId, int password, String email, String address,
			String businessName, int businessRegistrationNumber) {

		BussinessUser newUser = new BussinessUser(userName, userId, password, email, address, businessName,
				businessRegistrationNumber);
		Busers.add(newUser);
		System.out.println("\u001B[32m" + "New business user added successfully!");
	}

	// Add Individual User
	public void addIndividualUser(String userName, int userId, int password, String email, String address,
			String socialSecurityNumber) {

		IndividualUser newUser = new IndividualUser(userName, userId, password, email, address, socialSecurityNumber);
		Iusers.add(newUser);
		System.out.println("\u001B[32m" + "New individual user added successfully!");
	}

	// Display bank details
	public void displayBankDetails() {
		System.out.println("\u001B[36m" + "Bank Name: " + name);
		System.out.println("Bank ID  : " + id);
	}

	// Display bank users
	public void displayBankUsers() {
		System.out.println("\u001B[33m" + "Business Users: ");
		for (BussinessUser user : Busers) {
			user.displayBussinesUserDetails();
		}

		System.out.println("\u001B[33m" + "Individual Users: ");
		for (IndividualUser user : Iusers) {
			user.displayIndividualUsersDetails();
		}
	}

	public static void main(String[] args) {

		// Initialize the Bank instance
		Bank bank = new Bank("Haider Bank Limited", 22);

		// Display welcome message
		System.out.println("\u001B[32m" + "##### Welcome To Haider Bank #####");

		// Add business user example
		bank.addBussinessUser("Alice", 101, 1234, "alice@example.com", "123 Business Street", "Alice Corp", 555);

		// Add individual user example
		bank.addIndividualUser("Bob", 102, 5678, "bob@example.com", "456 Individual Ave", "SSN123456");

		// Display bank details and users
		bank.displayBankDetails();
		bank.displayBankUsers();

		// User transaction examples
		User user1 = new User(111, "Ahmad", "ahmad@mail.com", "Muzaffarabad", 909831);
		try {
			// if invalid account number
			user1.createAccount(1, 0, 1100.0, "Business");
		} catch (InvalidAccountNumberException e) {
			System.out.println("\u001B[31m" +"Invalid Account Number " + e.getMessage());
		}
		user1.displayUserDetails();
		user1.displayAccountDetails();

		// Perform transactions
		try {
			user1.deposit(111, 300);
			// insufficient funds exception if balance is low
			user1.withdraw(111, 1400);
			user1.displayAccountDetails();
			user1.viewTransactionHistory();
		} catch (Exception e) {
			System.out.println("\u001B[31m" + "Transaction failed: " + e.getMessage());
		}
	}
}
