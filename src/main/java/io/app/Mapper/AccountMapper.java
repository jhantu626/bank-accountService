package io.app.Mapper;

import io.app.Dto.AccountDto;
import io.app.Model.Account;

public class AccountMapper {
	public static Account mapToAccount(AccountDto accountDto){
		Account account= Account.builder()
				.accountHolderName(accountDto.getAccountHolderName())
				.balance(accountDto.getBalance()).build();
		return account;
	}

	public static AccountDto mapToAccountDto(Account account){
		AccountDto accountDto= AccountDto.builder()
				.accountHolderName(account.getAccountHolderName())
				.id(account.getId())
				.balance(account.getBalance()).build();
		return accountDto;
	}

}
