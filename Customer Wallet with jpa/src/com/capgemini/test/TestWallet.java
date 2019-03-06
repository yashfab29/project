package com.capgemini.test;

import java.math.BigDecimal;
import java.sql.SQLException;
import org.junit.Test;
import com.capgemini.exceptions.DuplicateMobileNumberException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.MobileNumberNotFoundException;
import com.capgemini.service.WalletServiceImpl;

public class TestWallet {


	
	
	@Test(expected=com.capgemini.exceptions.MobileNumberNotFoundException.class)
	public void whenMobileNumberNotFoundForShowingBalance() throws MobileNumberNotFoundException, SQLException
	{
		WalletServiceImpl walletServiceImpl = new WalletServiceImpl();
		walletServiceImpl.showBalance("5791324863");
	}
	
	@Test(expected=com.capgemini.exceptions.MobileNumberNotFoundException.class)
	public void whenMobileNumberNotFoundForFundTransfer() throws MobileNumberNotFoundException, InsufficientBalanceException, SQLException
	{
		WalletServiceImpl walletServiceImpl = new WalletServiceImpl();
		BigDecimal amount = new BigDecimal(2000);
		walletServiceImpl.fundTransfer("9999999999", "8888888888", amount);
	}
	
	
	@Test(expected=com.capgemini.exceptions.MobileNumberNotFoundException.class)
	public void whenMobileNumberNotFoundForDeposit() throws MobileNumberNotFoundException, SQLException
	{
		WalletServiceImpl walletServiceImpl = new WalletServiceImpl();
		BigDecimal amount = new BigDecimal(2000);
		walletServiceImpl.depositAmount("9999999999", amount);
	}
}



