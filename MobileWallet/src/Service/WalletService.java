package Service;

import java.math.BigDecimal;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;
import Exception.DuplicateMobileNumberException;
import Exception.InsufficentBalanceException;

public interface WalletService {




	Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws InsufficentBalanceException;

	Customer depositAmount(String mobileNo, BigDecimal amount);

	Customer withDrawAmount(String mobileNo, BigDecimal amount) throws InsufficentBalanceException;

	Customer createAccount(String name, String mobileNo, Wallet wallet) throws DuplicateMobileNumberException;

}