package com.banking.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.application.dto.AccountDto;
import com.banking.application.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	AccountService aservice;
	@GetMapping("/hello")
	public String Display()
	{
		return "Hello";
	}
	
	@PostMapping("/addAccount")
	
	public ResponseEntity<AccountDto>addAccount(@RequestBody AccountDto accountDto)
	{
		return new ResponseEntity<>(aservice.createAccount(accountDto),HttpStatus.CREATED);
				
	}
	
	

}
