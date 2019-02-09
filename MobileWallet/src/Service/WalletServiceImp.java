package Service;

import java.math.BigDecimal;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;
import Exception.DuplicateMobileNumberException;
import Exception.InsufficentBalanceException;
import repo.WalletRepoInterface;

public class WalletServiceImp implements WalletService {
	
	
	WalletRepoInterface walletRepo;
	
	public WalletServiceImp(WalletRepoInterface walletRepo)
	{
		this.walletRepo = walletRepo;
	}
	
	
	@Override
	public Customer createAccount(String name, String mobileNo, Wallet wallet) throws DuplicateMobileNumberException 
	{
		
		Customer customer = new Customer(name, mobileNo, wallet); 
		
		if(walletRepo.findOne(mobileNo) == null) {
			walletRepo.save(customer);  
			return customer;
		}
		throw new DuplicateMobileNumberException();

	}
	
	
	
	public Customer showBalance(String mobileNo) 
	{	
		
			return walletRepo.findOne(mobileNo);
		
		
	}
	
	
	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws InsufficentBalanceException 
	{
			Customer sourceCustomer = walletRepo.findOne(sourceMobileNo);
			Customer targetCustomer = walletRepo.findOne(targetMobileNo);
			BigDecimal sourceAmount = sourceCustomer.getWallet().getBalance();
			int i = sourceAmount.compareTo(amount);
			if(i == -1) {
			throw new InsufficentBalanceException();
			}
			targetCustomer.getWallet().setBalance(targetCustomer.getWallet().getBalance().add(amount));
			sourceCustomer.getWallet().setBalance(sourceCustomer.getWallet().getBalance().subtract(amount));
			return targetCustomer;
		
	}
	
	
	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount)
	{
			Customer customer = walletRepo.findOne(mobileNo);
			customer.getWallet().setBalance(customer.getWallet().getBalance().add(amount));
			return customer;
	}
	
	
	@Override
	public Customer withDrawAmount(String mobileNo, BigDecimal amount) throws InsufficentBalanceException
	{
		
			Customer customer = walletRepo.findOne(mobileNo);
			BigDecimal amountInCustomer = customer.getWallet().getBalance();
			int i = amountInCustomer.compareTo(amount);
			if(i == -1) {
				throw new InsufficentBalanceException();
			}
			customer.getWallet().setBalance(customer.getWallet().getBalance().subtract(amount));
			return customer;
	}
	
}