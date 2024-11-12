package scd.lab.midproject;

public class IndividualUser extends User {

	private String socialSecurityNumber;

	public IndividualUser(String userName, int userId, int password, String email, String address, String socialSecurityNumber) {
		super(userId, userName, email, address, password);
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public void displayIndividualUserDetails() {
		System.out.println("\u001B[32m" + "Social Security Number: " + socialSecurityNumber);
		displayUserDetails();
	}
}