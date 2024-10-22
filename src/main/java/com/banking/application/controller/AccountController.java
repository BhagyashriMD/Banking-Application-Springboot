package com.banking.application.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
//	@GetMapping("/hello")
//	public String Display()
//	{
//		return "Hello";
//	}
	
	@PostMapping("/addAccount")
	
	public ResponseEntity<AccountDto>addAccount(@RequestBody AccountDto accountDto)
	{
		System.out.println(accountDto);//add toString method to display object
		return new ResponseEntity<>(aservice.createAccount(accountDto),HttpStatus.CREATED);
				
	}
	@GetMapping("/{id}")
	public ResponseEntity< AccountDto> getAccountById(@PathVariable Long id)
	{
		AccountDto accountDto=aservice.getAcountById(id);
		
		return ResponseEntity.ok(accountDto) ;
		
	}
	@PutMapping("{id}/deposite")
	public ResponseEntity< AccountDto> deposite(@PathVariable Long id,@RequestBody Map<String,Double>request)
	{
		Double amount=request.get("amount");
		AccountDto accountDto=aservice.deposite(id,amount);
		return  ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/{id}/withdraw")
	public  ResponseEntity<AccountDto>withdraw(@PathVariable Long id,@RequestBody Map<String,Double>request)
	{
		
		Double amount=request.get("amount");
		AccountDto accountDto=aservice.withdraw(id, amount);
		
		return ResponseEntity.ok(accountDto);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<AccountDto>>getAll()
	{
		List<AccountDto>accountDto=aservice.getAll();
		return ResponseEntity.ok(accountDto);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteAccount(@PathVariable Long id)
	{
		
		aservice.delete(id);
		return ResponseEntity.ok("Account Deleted Succesfully");
	}

}
