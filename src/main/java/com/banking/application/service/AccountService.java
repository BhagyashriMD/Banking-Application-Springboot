package com.banking.application.service;

import java.util.List;

import com.banking.application.dto.AccountDto;

public interface AccountService {
	

	abstract AccountDto createAccount(AccountDto account);

	abstract AccountDto getAcountById(Long id);
	
	abstract AccountDto deposite(Long id,double amount);
	abstract AccountDto withdraw(Long id,double amount);
	
	abstract List<AccountDto>getAll();
	
	abstract String delete(Long id);

}
