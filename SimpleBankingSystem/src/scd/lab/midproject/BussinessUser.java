package scd.lab.midproject;

import java.util.*;
public class BussinessUser extends User {

	// variables with default values
	private int bussinessRegistrationNumber = 112233;
	private String bussinessName = "Coding Organization";
	  List<Account> Baccounts;
	// default constructor
	BussinessUser() {}

	// parameterized constructor
	BussinessUser(String userName, int userid, int password, String email, String address, String bussinessName,
			int bussinessRegistrationNumber) {
		
		super(userid,userName, email, address, password);
		this.bussinessRegistrationNumber = bussinessRegistrationNumber;
		this.bussinessName = bussinessName;

	}
	
	/*void createBusinessAccount(int accountId, int UserId, int accountNumber, double initialBalance,double) {
		Account newaccount=new Account(accountId,UserId,accountNumber,initialBalance);
		accounts.add(newaccount);
		System.out.println("\u001B[32m" +"Congrats!\n"+"Bussiness Account created Successfuly!");
	}*/
	
	public void displayBussinesUserDetails() {
		System.out.println("\u001B[32m"+"Bussiness Name: "+bussinessName);
		System.out.println("Bussiness Registration Number: "+ bussinessRegistrationNumber);
		displayUserDetails();
	}
	
}
