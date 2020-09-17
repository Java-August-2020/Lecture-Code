package com.matthew.weddings.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.matthew.weddings.repositories.UserRepository;
import com.matthew.weddings.models.*;;




@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "Match", "Passwords do not match!!!!!!!!!");
		}
		
		// Make sure Email is unique in the Database
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "Email has already been registered!");
		}
		
		
		// No Matt's Allowed To Register
//		if(user.getFirstName().equals("Matt")){
//			errors.rejectValue("firstName", "NoMattsAllowed", "Sorry, we're not accepting Matt's at this time");
//		}
	}
}
