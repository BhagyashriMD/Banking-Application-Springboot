package com.banking.application.service;

import com.banking.application.dto.AccountDto;

public interface AccountService {

	abstract AccountDto createAccount(AccountDto account);

	AccountDto getAcountById(Long id);
	
	AccountDto deposite(Long id,double amount);
	AccountDto withdraw(Long id,double amount);

}
