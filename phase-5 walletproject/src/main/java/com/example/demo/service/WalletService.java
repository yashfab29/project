package com.example.demo.service;

import java.util.List;

import com.example.demo.beans.Customer;

public interface WalletService {

	Customer createAccount(Customer customer);
	
	public Customer showById(String mobileNo);

	Customer deposit(String mobileNo, double balance); 
	
	Customer withDraw(String mobileNo, double balance);

	Customer fundtransfer(String sourceMobileNo, String targetMobileNo, double balance);

	List<Customer> showAll();

}