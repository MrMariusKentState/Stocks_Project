package com.MariusPaulikas.Servlet.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	
	
	@RequestMapping(value="/registration/submit", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, HttpSession session) {
		 uservalidator.validate(user, result);
		 if(result.hasErrors()) {
			 return "home.jsp";
		 }
		 
		 else {
			 User newuser = userservice.registerUser(user);
			 session.setAttribute("userId", newuser.getId());
			 return "redirect:/dashboard";
			 
		 }
		 
	 }
	
	

	@RequestMapping (value="/login", method=RequestMethod.POST) 
	public String loginUser (@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectattributes) {
		 if(userservice.authenticateUser(email, password)) {
			User user = userservice.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/dashboard";
		 }
		 
		 else {
			 redirectattributes.addFlashAttribute("error", "Your email or password is not correct. Please try again.");
			 return "redirect:/home";
		 }
	    
	 }
	
	
	
	@RequestMapping("/dashboard")
	public String Dashboard(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/home";
		}
		
		Long l = (Long)session.getAttribute("userId");
		User user = userservice.findUserById(l);
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}
	
	
	
}
