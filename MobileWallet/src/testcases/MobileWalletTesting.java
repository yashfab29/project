package testCases;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.beans.Wallet;
import Exception.DuplicateMobileNumberException;
import  Exception.InsufficentBalanceException;
import repo.WalletRepoInterface;
import repo.WalletRepositoryImp;
import Service.WalletService;
import Service.WalletServiceImp;

public class MobileWalletTesting {

	
	WalletRepoInterface walletRepo = (WalletRepoInterface) new WalletRepositoryImp();
	WalletService walletService = new WalletServiceImp(walletRepo);
	
	
	@Test(expected = Exception)
	public void WhenTheBalanceIsNotEnoughToWithDrawThenThrowAnError() throws InsufficentBalanceException, DuplicateMobileNumberException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		BigDecimal withdrawAmount = new BigDecimal(2000);
		walletService.withDrawAmount("8171575996", withdrawAmount );
	}
	
	@Test(expected =Exception.InsufficentBalanceException.class)
	public void WhenTheBalanceIsNotEnoughToTransferThenThrowAnError() throws InsufficentBalanceException, DuplicateMobileNumberException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal amount2 = new BigDecimal(500);
		Wallet wallet2 = new Wallet(amount2);
		
		walletService.createAccount("balveer", "8755560521", wallet2);
		
		BigDecimal fundTransfer = new BigDecimal(2000);
		walletService.fundTransfer("8171575996", "8755560521", fundTransfer);
		
	}
	
	@Test(expected = Exception.DuplicateMobileNumberException.class)
	public void WhenTheMobileNumberIsDuplicateThenThrowAnError() throws InsufficentBalanceException, DuplicateMobileNumberException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal amount2 = new BigDecimal(500);
		Wallet wallet2 = new Wallet(amount2);
		
		walletService.createAccount("balveer", "8171575996", wallet2);
		
	}

	
	
	@Test
	public void WhenTheAllTheDetailsGivenValidThenAccountCreatedSuccessfully() throws DuplicateMobileNumberException {
	
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
	}
	
	@Test
	public void WhenTheAllTheDetailsGivenValidThenDepositedSuccessfully() throws DuplicateMobileNumberException {
	
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal amount = new BigDecimal(500);
		walletService.depositAmount("8171575996", amount);
		
	}
	
	@Test
	public void WhenTheAllTheDetailsGivenValidThenTheAmountWithDrawSuccessfully() throws DuplicateMobileNumberException, InsufficentBalanceException {
	
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal amount = new BigDecimal(500);
		walletService.withDrawAmount("8171575996", amount);
		
	}
	
	
	@Test
	public void WhenAllTheDetailsGivenValidThenTheFundTransferredSuccessfully() throws InsufficentBalanceException, DuplicateMobileNumberException{
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("vikash", "8171575996", wallet1);
		
		BigDecimal amount2 = new BigDecimal(500);
		Wallet wallet2 = new Wallet(amount2);
		
		walletService.createAccount("balveer", "8755560521", wallet2);
		
		BigDecimal amount3 = new BigDecimal(500);
		walletService.fundTransfer("8171575996", "8755560521", amount3);
		
	}
	
	
	

}