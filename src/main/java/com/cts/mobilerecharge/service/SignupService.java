package com.cts.mobilerecharge.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.mobilerecharge.bean.User;
import com.cts.mobilerecharge.repository.SignupRepository;

@Service
public class SignupService {

	private SignupRepository signupRepository;

	@Autowired
	public void setSignupRepository(SignupRepository signupRepository) {

		this.signupRepository = signupRepository;
	}

	@Transactional

	public void signup(User user) {

		signupRepository.save(user);
	}
}
