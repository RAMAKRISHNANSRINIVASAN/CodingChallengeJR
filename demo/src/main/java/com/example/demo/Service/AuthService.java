package com.example.demo.Service;

import com.example.demo.Entity.SignupRequest;
import com.example.demo.Entity.User;

public interface AuthService {
	User createUser(SignupRequest signupRequest);

	boolean hasCustomerWithEmail(String email);

	
}