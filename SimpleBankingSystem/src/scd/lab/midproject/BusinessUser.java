package scd.lab.midproject;

public class BusinessUser extends User {

	private int businessRegistrationNumber;
	private String businessName;

	public BusinessUser(String userName, int userId, int password, String email, String address, String businessName, int businessRegistrationNumber) {
		super(userId, userName, email, address, password);
		this.businessRegistrationNumber = businessRegistrationNumber;
		this.businessName = businessName;
	}

	public void displayBusinessUserDetails() {
		System.out.println("\u001B[32m" + "Business Name: " + businessName);
		System.out.println("Business Registration Number: " + businessRegistrationNumber);
		displayUserDetails();
	}
}