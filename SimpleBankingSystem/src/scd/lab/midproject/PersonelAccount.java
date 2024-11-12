package scd.lab.midproject;

public class PersonelAccount extends Account {
	/// variables and default values
	double overDraftLimit = 0000000;

	// default constructor
	PersonelAccount() {
	}

	public double getOverDraftLimit() {
		return overDraftLimit;
	}
	
	// parametrized constructor
	PersonelAccount(int accountId, int UserId, int accountNumber, double initialBalance, double overDraftLimit) {
		super(accountId, UserId, accountNumber, initialBalance);
		this.overDraftLimit = overDraftLimit;
	}
	
	

}
