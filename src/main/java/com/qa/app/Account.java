package com.qa.app;

public class Account {
		
	private int id;
	private String firstName;
	private String lastName;
	private int accountNumber;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public void setLastName(String name) {
		this.lastName = name;
	}
	
	public void setAccountNumber(int accNum) {
		this.accountNumber = accNum;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	
}
