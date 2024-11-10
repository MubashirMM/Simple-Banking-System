package scd.lab.midproject;

public class IndividualAccount extends Account {
	/// variables and default values
	double overDraftLimit = 0000000;

	// default constructor
	IndividualAccount() {
	}

	// parametrized constructor
	IndividualAccount(int accountId, int UserId, int accountNumber, double initialBalance,String accountType, double overDraftLimit) {
		super(accountId, UserId, accountNumber, initialBalance,accountType);
		this.overDraftLimit = overDraftLimit;
	}

}
