package com.matthew.dogs.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.dogs.models.Dog;
import com.matthew.dogs.models.User;
import com.matthew.dogs.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public User registerUser(User user) {
		// Generate Hash
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		// Set The hashed password on the User's password field
		user.setPassword(hash);
		// Save that new user with the hashed password to the database
		return this.uRepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password) {
		// Make sure the user logging in is WHO THEY SAY THEY ARE
		// Step 1: Try and query for the user by email
		User user = this.uRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		}
		
		// Step 2 check provided email against email in the database for the user
		return BCrypt.checkpw(password, user.getPassword());				
	}
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	
	public User getOneUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
}
