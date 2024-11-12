// Main.java
package scd.lab.midproject;

public class Main {

	public static void main(String[] args) {

		// Creating a business user
		BusinessUser bu = new BusinessUser("Mubashir", 111, 111, "email@gmail.com", "Lahore", "Clothings", 12345);
		/*bu.createBusinessAccount(1, 10001, 50000, 20000);
		bu.displayBusinessUserDetails();
		try {
		bu.deposit(111, 20);
		}catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}

		try {
			bu.withdraw(111, 200);
		}catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}*/
		bu.viewTransactionHistory();
		// Creating a personal user
		IndividualUser iu = new IndividualUser("Ali", 222, 222, "ali@gmail.com", "Karachi", "SSN-12345678");
		/*iu.createPersonalAccount(2, 10002, 30000, 5000);
		iu.displayIndividualUserDetails();
		try {
			iu.deposit(222, 20);
			}catch(InsufficientBalanceException e) {
				System.out.println(e.getMessage());
			}
			bu.viewTransactionHistory();
			try { 
				iu.withdraw(222, 200);
			}catch(InsufficientBalanceException e) {
				System.out.println(e.getMessage());
			}*/
		iu.viewTransactionHistory();
	}
} 
