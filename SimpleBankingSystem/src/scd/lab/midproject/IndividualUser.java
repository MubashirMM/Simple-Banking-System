package scd.lab.midproject;

public class IndividualUser extends User{

	//variables with initial values
	private String socialSecurityNumber="Mu1232142";
	
	//default constructor
	IndividualUser(){}

	//parametrized constructor
	IndividualUser(String userName, int userid, int password, String email, String address,String socialSecurityNumber ){
		
		super(userid,userName, email, address, password);
		this.socialSecurityNumber=socialSecurityNumber;
	}
	
	public void displayIndividualUsersDetails() {
		System.out.println("\u001B[32m" + "Social Security Number: "+socialSecurityNumber);
		displayUserDetails();
	}
}
