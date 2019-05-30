package com.qa.accountTest;

import org.junit.Before;
import org.junit.Test;

import com.qa.app.Account;
import com.qa.app.AccountRepositoryDB;
import com.qa.app.AccountRepositoryMap;

import static org.junit.Assert.*;


public class AccountTest {
	Account account;
	
	@Before
	public void InitTest(){
		account = new Account();
		account.setId(0);
		account.setFirstName("Chris");
		account.setLastName("Perrins");
		account.setAccountNumber(3);		
	}
	
	@Test
	public void createAccountID() {
		assertEquals("ID is wrong", 0, account.getId());
		
	}
	
	@Test
	public void createAccountFirstName() {
		assertEquals("ID is wrong", "Chris", account.getFirstName());
		
	}
	@Test
	public void createAccountLastName() {
		assertEquals("ID is wrong", "Perrins", account.getLastName());
		
	}
	@Test
	public void createAccountNum() {
		assertEquals("ID is wrong", 3, account.getAccountNumber());
		
	}
	
	
	@Test
	public void accountRepositoryMapTest() {
		AccountRepositoryMap arm = new AccountRepositoryMap();
		arm.add(account);
		Account retrieved = arm.retrieve(account.getId());
		assertEquals("Wrong Account Retrieved", "Chris", retrieved.getFirstName());
		assertEquals("Wrong Account", account, retrieved);
	}
	
	@Test
	public void DBTest() {
		Account a = new Account();
		AccountRepositoryDB db = new AccountRepositoryDB();
		db.add(a);
		int id = a.getId();
		Account accountBack = db.retrieve(id);
		assertEquals(a, accountBack);
	}
	
	@Test
	public void DBupdate() {
		AccountRepositoryDB db = new AccountRepositoryDB();
		account.setFirstName("Adrian");
		db.add(account);
		int id = account.getId();
		db.updateFirstName(id,"Danny");
		String firstName = account.getFirstName();
		assertEquals("Wrong name updated", "Danny", firstName);
	}
	
	@Test
	public void removeAccount() {
		AccountRepositoryDB db = new AccountRepositoryDB();
		db.add(account);
		int id = account.getId();
		db.remove(id);
		assertNull("Not Null", db.retrieve(id));
	}
}

