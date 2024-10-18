package com.banking.application.service;

import com.banking.application.dto.AccountDto;


public interface AccountService {
	
	abstract AccountDto createAccount(AccountDto account);
	

}
