package io.app.Service.Impl;

import io.app.Dto.AccountDto;
import io.app.Mapper.AccountMapper;
import io.app.Model.Account;
import io.app.Repository.AccountRepository;
import io.app.Service.AccountService;
import io.app.Exceptions.InsufficientBalance;
import io.app.Exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository repository;

	public AccountDto createAccount(AccountDto accountDto) {
		Account account= AccountMapper.mapToAccount(accountDto);
		return AccountMapper.mapToAccountDto(repository.save(account));
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account=repository.findById(id).orElseThrow(()->new NotFoundException("Account Does not Exist: "+id));
		AccountDto accountDto=AccountMapper.mapToAccountDto(account);
		return accountDto;
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account=repository.findById(id).orElseThrow(()->new NotFoundException("Account Does not Exist: "+id));
		double d = account.getBalance() + amount;
		account.setBalance(d);
		Account account1=repository.save(account);
		return AccountMapper.mapToAccountDto(account1);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account=repository.findById(id).orElseThrow(()->new NotFoundException("Account Does not Exist: "+id));
		if (account.getBalance()<amount) {
			throw new InsufficientBalance("Insufficient Balance");
		}
		double total=account.getBalance()-amount;
		account.setBalance(total);
		return AccountMapper.mapToAccountDto(repository.save(account));
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<AccountDto> list = repository.findAll().stream().map(t->{
			return AccountMapper.mapToAccountDto(t);
		}).collect(Collectors.toList());
		return list;
	}

	@Override
	public void deleteAccount(Long id) {
		Account account=repository.findById(id).orElseThrow(()->new NotFoundException("Account Does not Exist: "+id));
		repository.delete(account);
	}

}
