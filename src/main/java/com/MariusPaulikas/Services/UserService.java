package com.MariusPaulikas.Services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.MariusPaulikas.Models.Banking;
import com.MariusPaulikas.Models.Brokerage;
import com.MariusPaulikas.Models.User;
import com.MariusPaulikas.Repositories.UserRepository;


@Service
public class UserService {
	
	private final UserRepository userrepository;
	
	public UserService(UserRepository userrepository) {
		this.userrepository = userrepository;
	}
	
	public List<User> allUsers() {
		return userrepository.findAll();
	}
	
	public User createUser (User u) {
		return userrepository.save(u);
	}
	
	public User findUsers(Long id) {
		Optional<User> optionalUsers = userrepository.findById(id);
		if(optionalUsers.isPresent()) {
			return optionalUsers.get();
		} else {
			return null;
		}
		
	}
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userrepository.save(user);
	}
	
	
	public User findByEmail(String email) {
		return userrepository.findByEmail(email);
	}
	
	
	public User findUserById(Long id) {
		Optional<User>u = userrepository.findById(id);
		
		if(u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

	
	public boolean authenticateUser(String email, String password) {
		User user = userrepository.findByEmail(email);
		if(user == null) {
			return false;
		} else {
			
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
		} 	else {
				return false;
		}
	}
	
	}	
	
	
	public User AddBankAccount (User u, Banking b) {
		List<Banking>bankaccounts = u.getAddbankacct();
		bankaccounts.add(b);
		return userrepository.save(u);
		
	}
	
	
	public User RemoveBankAccount (User u, Banking b) {
		List<Banking>bankaccounts = u.getAddbankacct();
		bankaccounts.remove(b);
		return userrepository.save(u);
	}
		
	
	
	public User AddBrokerageAccount (User u, Brokerage br) {
		List<Brokerage>brokerageaccounts = u.getAddbrokerageacct();
		brokerageaccounts.add(br);
		return userrepository.save(u);
	}
	
	
	public User RemoveBrokerageAccount (User u, Brokerage br) {
		List<Brokerage>brokerageaccounts = u.getAddbrokerageacct();
		brokerageaccounts.remove(br);
		return userrepository.save(u);
	
	
	}
	
	
}
