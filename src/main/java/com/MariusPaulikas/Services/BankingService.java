package com.MariusPaulikas.Services;

import java.util.List;
import java.util.Optional;

import com.MariusPaulikas.Models.Banking;
import com.MariusPaulikas.Repositories.BankingRepository;

public class BankingService { 
	
	private final BankingRepository bankingrepository;
	
	public BankingService(BankingRepository bankingrepository) {
		this.bankingrepository = bankingrepository;
	}
	
	public List<Banking> allAccounts() {
		return bankingrepository.findAll();
	}
	
	
	public Banking findAccounts(Long id) {
		Optional<Banking> oneaccount = bankingrepository.findById(id);
		if(oneaccount.isPresent()) {
			return oneaccount.get();
		}
		else {
			return null;
		}
	
	}
}
