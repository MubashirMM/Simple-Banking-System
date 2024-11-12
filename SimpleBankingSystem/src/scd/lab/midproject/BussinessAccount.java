package scd.lab.midproject;

public class BussinessAccount extends Account {

	// variables with default values
	private double creditLimit = 00000;
	
	// default constructor
	BussinessAccount() {}
	public double getCreditLimit() {
		return creditLimit;
	} 
	// parametrized constructor
	BussinessAccount(int accountId, int UserId, int accountNumber, double initialBalance,double creditLimit) {
		super(accountId, UserId, accountNumber, initialBalance);
		this.creditLimit = creditLimit;
	}
			
}
