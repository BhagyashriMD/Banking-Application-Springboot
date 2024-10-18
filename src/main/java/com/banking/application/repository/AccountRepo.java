package com.banking.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banking.application.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long>
{
	
	
	

}
