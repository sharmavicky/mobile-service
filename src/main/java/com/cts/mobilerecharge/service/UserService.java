package com.cts.mobilerecharge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.mobilerecharge.bean.User;
import com.cts.mobilerecharge.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public User getUser(String mobileNumber) {
		return (User) userRepository.findBymobileNumber(mobileNumber);

	}
}