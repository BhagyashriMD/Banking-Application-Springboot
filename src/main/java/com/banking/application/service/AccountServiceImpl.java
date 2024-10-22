package com.banking.application.service;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public AccountDto getAcountById(Long id) {
		
		Account account=accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account does not exist"));
		
		
		return AccountMapper.mapToAccountDto(account);
		
		
	}

	@Override
	public AccountDto deposite(Long id, double amount) {
		Account account=accountRepo.getById(id);
		double totalbalance=account.getBalance()+amount;
		account.setBalance(totalbalance);
		accountRepo.save(account);
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account=accountRepo.findById(id).orElseThrow(()->new RuntimeException(" Id Not found"));
		if(account.getBalance()<amount)
		{
			throw new RuntimeException("Insufficient Balance");
		}
		
		double totalbalance=account.getBalance()-amount;
		
		account.setBalance(totalbalance);
		Account saveAccount=accountRepo.save(account);
		
		return AccountMapper.mapToAccountDto(saveAccount);
	}

	@Override
	public List<AccountDto> getAll() {
		return accountRepo.findAll().stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		
		
	}

	@Override
	public String delete(Long id) {
		Account account=accountRepo.findById(id).orElseThrow(()->new RuntimeException(" Id Not found"));
		accountRepo.delete(account);
		return "Deleted Succesfully";
	}

}
