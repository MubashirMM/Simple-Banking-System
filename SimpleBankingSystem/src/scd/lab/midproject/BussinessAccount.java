package scd.lab.midproject;

public class BussinessAccount extends Account {

	// variables with default values
	private double creditLimit = 00000;
	
	// default constructor
	BussinessAccount() {
	}

	// parametrized constructor
	BussinessAccount(int accountId, int UserId, int accountNumber, double initialBalance,String accountType, double creditLimit) {
		super(accountId, UserId, accountNumber, initialBalance,accountType);
		this.creditLimit = creditLimit;
	}
	
	
		
}
