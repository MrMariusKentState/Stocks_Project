package com.MariusPaulikas.Services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

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
	
	

}
