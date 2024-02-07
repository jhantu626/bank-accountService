package io.app.Service;

import io.app.Dto.AccountDto;
import io.app.Model.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface AccountService {
	public AccountDto createAccount(AccountDto account);
	public AccountDto getAccountById(Long id);
	public AccountDto deposit(Long id,double amount);
	public AccountDto withdraw(Long id,double amount);
	public List<AccountDto> getAllAccounts();

	public void deleteAccount(Long id) throws AccountNotFoundException;
}
