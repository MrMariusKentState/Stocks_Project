package com.MariusPaulikas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MariusPaulikas.Services.BankingService;
import com.MariusPaulikas.Services.BrokerageService;
import com.MariusPaulikas.Services.UserService;
import com.MariusPaulikas.Validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	
	@Autowired
	private BankingService bankingservice;
	
	@Autowired
	private BrokerageService brokerageservice;
	
	@Autowired
	private final UserValidator uservalidator;
	
	
	public UserController (UserService userservice, BankingService bankingservice, BrokerageService brokerageservice, UserValidator uservalidator) {
		this.userservice = userservice;
		this.bankingservice = bankingservice;
		this.brokerageservice = brokerageservice;
		this.uservalidator = uservalidator;
	}
	
	
	@RequestMapping("/home")
	public String HomePage()  {
		return "home.jsp";
	}
	
	
	
}
