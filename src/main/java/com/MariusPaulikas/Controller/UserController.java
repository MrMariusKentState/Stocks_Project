package com.MariusPaulikas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.MariusPaulikas.Services.BankingService;
import com.MariusPaulikas.Services.BrokerageService;
import com.MariusPaulikas.Services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	
	@Autowired
	private BankingService bankingservice;
	
	@Autowired
	private BrokerageService brokerageservice;
	
	
	public UserController (UserService userservice, BankingService bankingservice, BrokerageServic brokerageservice, UserValidator uservalidator) {
		this.userservice = userservice;
		this.bankingservice = bankingservice;
		this.brokerageservice = brokerageservice;
		this.uservalidator = uservalidator;
	}
	
	
	
	
	
	
	
}
