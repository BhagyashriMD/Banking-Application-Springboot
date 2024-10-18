package com.banking.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.application.dto.AccountDto;
import com.banking.application.entity.Account;
import com.banking.application.mapper.AccountMapper;
import com.banking.application.repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {

//	@Autowired
	private AccountRepo accountRepo;

//better to use constructor injection
	public AccountServiceImpl(AccountRepo accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account saveAccount = accountRepo.save(account);

		return AccountMapper.mapToAccountDto(saveAccount);
	}

}
