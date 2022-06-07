package com.MariusPaulikas.Servlet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MariusPaulikas.Servlet.Models.User;
import com.MariusPaulikas.Servlet.Services.BankingService;
import com.MariusPaulikas.Servlet.Services.BrokerageService;
import com.MariusPaulikas.Servlet.Services.UserService;
import com.MariusPaulikas.Servlet.Validator.UserValidator;

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
	public String HomePage(@ModelAttribute("newuser") User user )  {
		return "home.jsp";
	}
	
	
	
}
